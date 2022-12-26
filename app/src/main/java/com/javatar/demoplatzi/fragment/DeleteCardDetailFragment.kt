package com.javatar.demoplatzi.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.databinding.FragmentCardDetailBinding
import com.javatar.demoplatzi.listener.OnBottomNavigationActions
import com.javatar.demoplatzi.listener.OnCardDataListener
import com.javatar.demoplatzi.listener.OnToolbarActions
import com.javatar.demoplatzi.viewmodel.CardDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeleteCardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    private val viewModel: CardDetailViewModel by viewModels()
    private lateinit var binding: FragmentCardDetailBinding
    private var onCardDataListener: OnCardDataListener? = null
    private var onToolbarActions: OnToolbarActions? = null
    private var onBottomNavigationActions: OnBottomNavigationActions? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        onToolbarActions?.apply {
            isEnabledIconBack(true)
        }
        onBottomNavigationActions?.apply {
            hideBottomNavigation()
        }
        onCardDataListener?.let { data ->
            showView()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_detail_card, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                onCardDataListener?.let { data ->
                    data.getData().card?.let { card ->
                        viewModel.saveCard(card)
                        Toast.makeText(context, resources.getText(R.string.message_add_card), Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            R.id.action_delete -> {
                onCardDataListener?.let { data ->
                    data.getData().card?.let { card ->
                        viewModel.deleteCard(card)
                        Toast.makeText(context, resources.getText(R.string.message_delete_card), Toast.LENGTH_SHORT).show()
                        findNavController().navigateUp()
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showView() {
        onCardDataListener?.let { data ->
            with(binding) {
                Glide.with(imageViewCard)
                    .load(data.getData().getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(imageViewCard)
            }
        }
    }
}