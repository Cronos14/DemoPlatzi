package com.javatar.demoplatzi.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.adapter.ComponentAdapter
import com.javatar.demoplatzi.component.Component
import com.javatar.demoplatzi.databinding.FragmentDeckBinding
import com.javatar.demoplatzi.factory.DeckViewHolderFactory
import com.javatar.demoplatzi.listener.OnBottomNavigationActions
import com.javatar.demoplatzi.listener.OnToolbarActions
import com.javatar.demoplatzi.viewmodel.DeckViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeckFragment : Fragment(R.layout.fragment_deck) {

    private lateinit var binding: FragmentDeckBinding
    private val viewModel: DeckViewModel by viewModels()
    private val components = arrayListOf<Component>()
    private var onToolbarActions: OnToolbarActions? = null
    private var onBottomNavigationActions: OnBottomNavigationActions? = null

    private val cardNavController by lazy {
        findNavController()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
        binding = FragmentDeckBinding.inflate(inflater, container, false)
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
        with(binding) {
            recyclerViewDeck.adapter = ComponentAdapter(
                DeckViewHolderFactory(),
                components
            )

            recyclerViewDeck.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        setupDeck()
        viewModel.getDeck()
    }

    private fun setupDeck() {
        viewModel.deck.observe(
            viewLifecycleOwner
        ) {
            components.clear()
            components.addAll(it)
            binding.recyclerViewDeck.adapter?.notifyDataSetChanged()
        }
    }
}