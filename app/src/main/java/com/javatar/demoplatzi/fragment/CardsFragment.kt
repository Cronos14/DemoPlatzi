package com.javatar.demoplatzi.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.adapter.CardsAdapter
import com.javatar.demoplatzi.adapter.FooterAdapter
import com.javatar.demoplatzi.collect
import com.javatar.demoplatzi.collectLast
import com.javatar.demoplatzi.databinding.FragmentCardsBinding
import com.javatar.demoplatzi.listener.OnBottomNavigationActions
import com.javatar.demoplatzi.listener.OnCardDataListener
import com.javatar.demoplatzi.listener.OnToolbarActions
import com.javatar.demoplatzi.models.CardsUiState
import com.javatar.demoplatzi.viewmodel.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map

@AndroidEntryPoint
class CardsFragment : Fragment(R.layout.fragment_cards) {

    private lateinit var binding: FragmentCardsBinding
    private val viewModel: CardsViewModel by viewModels()
    private var onCardDataListener: OnCardDataListener? = null
    private var onToolbarActions: OnToolbarActions? = null
    private var onBottomNavigationActions: OnBottomNavigationActions? = null

    lateinit var cardsAdapter: CardsAdapter

    private val cardNavController by lazy {
        findNavController()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCardDataListener) {
            onCardDataListener = context
        }
        if (context is OnToolbarActions) {
            onToolbarActions = context
        }
        if (context is OnBottomNavigationActions) {
            onBottomNavigationActions = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onToolbarActions?.apply {
            isEnabledIconBack(false)
        }
        onBottomNavigationActions?.apply {
            showBottomNavigation()
        }
        cardsAdapter = CardsAdapter {
            onCardDataListener?.getData()?.card = it.card
            cardNavController.navigate(R.id.action_cardsFragment_to_cardDetailFragment)
        }
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
        binding.recyclerViewCards.layoutManager = GridLayoutManager(context, LIMIT_ROW)

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

    companion object {
        const val LIMIT_ROW = 5
    }
}