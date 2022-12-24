package com.javatar.demoplatzi.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.databinding.FragmentCardDetailBinding
import com.javatar.demoplatzi.listener.OnCardDataListener
import com.javatar.demoplatzi.viewmodel.CardDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    private val viewModel: CardDetailViewModel by viewModels()
    private lateinit var binding: FragmentCardDetailBinding
    private var onCardDataListener: OnCardDataListener? = null
    private val cardNavController by lazy {
        findNavController()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCardDataListener) {
            onCardDataListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCardDataListener?.let { data ->
            showView()
        }
    }

    private fun showView() {
        onCardDataListener?.let { data ->
            with(binding) {
                Glide.with(imageViewCard)
                    .load(data.getData().getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(imageViewCard)
                imageViewAdd.setOnClickListener {
                    data.getData().card?.let { card ->
                        viewModel.saveCard(card)
                        Toast.makeText(context, "Carta Agregada al Deck", Toast.LENGTH_SHORT).show()
                    }
                }
                imageViewDelete.setOnClickListener {
                    cardNavController.navigate(R.id.action_cardDetailFragment_to_deckFragment)
                }
            }
        }
    }
}