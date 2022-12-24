package com.javatar.demoplatzi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.javatar.demoplatzi.*
import com.javatar.demoplatzi.adapter.CardsAdapter
import com.javatar.demoplatzi.adapter.FooterAdapter
import com.javatar.demoplatzi.databinding.FragmentCardsBinding
import com.javatar.demoplatzi.viewmodel.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CardsFragment : Fragment(R.layout.fragment_cards) {

    private lateinit var binding: FragmentCardsBinding
    private val viewModel: CardsViewModel by viewModels()

    @Inject
    lateinit var cardsAdapter: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.test.text = "Hola"
//
//        viewModel.cards.observe(viewLifecycleOwner) { it ->
//            var chain = ""
//            it.forEach { card ->
//                chain += "$card'\n\n\n'"
//            }
//
//            binding.test.text = chain
//        }

//        viewModel.getCards()

        setRetryListener()
        setAdapter()
        collectLast(viewModel.cardsUiStates, ::setCards)
    }

    private fun setRetryListener() {
        binding.buttonRetryCards.setOnClickListener { cardsAdapter.retry() }
    }

    private fun setAdapter() {
        collect(flow = cardsAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setCardsUiState
        )
        binding.recyclerViewCards.adapter =
            cardsAdapter.withLoadStateFooter(FooterAdapter(cardsAdapter::retry))
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(context)

    }

    private fun setCardsUiState(loadState: LoadState) {
        with(binding) {
            val cardsUiState = CardsUiState(loadState)
            recyclerViewCards.visibility = cardsUiState.getListVisibility()
            progressBarCards.visibility = cardsUiState.getProgressBarVisibility()
            buttonRetryCards.visibility = cardsUiState.getErrorVisibility()
            tvError.visibility = cardsUiState.getErrorVisibility()
            context?.let { context ->
                tvError.text = cardsUiState.getErrorMessage(context)
            }
        }
    }

    private suspend fun setCards(cardsPagingData: PagingData<CardItemUiState>) {
        cardsAdapter.submitData(cardsPagingData)
    }
}