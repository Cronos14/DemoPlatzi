package com.javatar.demoplatzi.deck.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.common.adapter.ComponentAdapter
import com.javatar.demoplatzi.common.component.*
import com.javatar.demoplatzi.common.factory.DeckItemType
import com.javatar.demoplatzi.common.factory.ViewHolderFactory
import com.javatar.demoplatzi.common.listener.*
import com.javatar.demoplatzi.databinding.FragmentDeckBinding
import com.javatar.demoplatzi.deck.viewholder.*
import com.javatar.demoplatzi.deck.viewmodel.DeckViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeckFragment : Fragment(R.layout.fragment_deck), ComponentClickListener {

    private lateinit var binding: FragmentDeckBinding
    private val viewModel: DeckViewModel by viewModels()
    private val components = arrayListOf<Component>()
    private var onCardDataListener: OnCardDataListener? = null
    private var onToolbarActions: OnToolbarActions? = null
    private var onBottomNavigationActions: OnBottomNavigationActions? = null

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


        val viewHolders = listOf(
            Pair(MonsterCardComponent::class.java, MonsterCardView()),
            Pair(SpellCardComponent::class.java, SpellCardView()),
            Pair(TrapCardComponent::class.java, TrapCardView())
        )

        val viewHoldersOnly = listOf(
            MonsterCardView(),
            SpellCardView(),
            TrapCardView()
        )

        val viewHoldersScalable = linkedMapOf(
            Pair(DeckItemType.MONSTER_CARD.type, MonsterCardView()),
            Pair(DeckItemType.SPELL_CARD.type, SpellCardView()),
            Pair(DeckItemType.TRAP_CARD.type, TrapCardView()),
        )

        with(binding) {
            recyclerViewDeck.adapter = ComponentAdapter(
//                DeckViewHolderFactory(),
                ViewHolderFactory(
                    //Error by generic, remember that the generic type is the same of the class and only can be one
                    viewHoldersOnly
                ),
//                ViewHolderScalableFactory(
//                    viewHoldersScalable
//                ),
                components,
                this@DeckFragment
            )

            recyclerViewDeck.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        setupDeck()
        setupEmpty()
        viewModel.getDeck()
    }

    private fun setupDeck() {
        viewModel.deck.observe(
            viewLifecycleOwner
        ) {
            components.clear()
            components.addAll(it)
            showEmpty(false)
            binding.recyclerViewDeck.adapter?.notifyDataSetChanged()
        }
    }

    private fun setupEmpty() {
        viewModel.empty.observe(
            viewLifecycleOwner
        ) {
            showEmpty(true)
        }
    }

    private fun showEmpty(value: Boolean) {
        binding.textViewEmpty.isVisible = value
        binding.recyclerViewDeck.isVisible = !value
    }

    override fun onComponentClicked(clicked: ComponentListener) {
        when (clicked) {
            is DeckHolderListener -> deckHolderListener(clicked)
            is EffectListener -> effectListener(clicked)
        }
        cardNavController.navigate(
            R.id.action_deckFragment_to_deleteCardDetailFragment
        )
    }

    private fun deckHolderListener(deckHolderListener: DeckHolderListener) {
        onCardDataListener?.getData()?.card = when (deckHolderListener) {
            is DeckHolderListener.MonsterItemClickListener -> deckHolderListener.component.toCard()
            is DeckHolderListener.SpellItemClickListener -> deckHolderListener.component.toCard()
            is DeckOther.OtherMonsterItemClickListener -> deckHolderListener.component.toCard()
            is DeckExtraListener.ExtraMonsterItemClickListener -> deckHolderListener.component.toCard()
        }
    }

    private fun effectListener(effectListener: EffectListener) {
        onCardDataListener?.getData()?.card = when (effectListener) {
            is EffectListener.TrapItemClickListener -> effectListener.component.toCard()
        }
    }
}