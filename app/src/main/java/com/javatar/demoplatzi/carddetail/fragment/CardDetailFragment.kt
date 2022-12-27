package com.javatar.demoplatzi.carddetail.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.databinding.FragmentCardDetailBinding
import com.javatar.demoplatzi.common.listener.OnBottomNavigationActions
import com.javatar.demoplatzi.common.listener.OnCardDataListener
import com.javatar.demoplatzi.common.listener.OnToolbarActions
import com.javatar.demoplatzi.common.viewmodel.CardDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    private lateinit var binding: FragmentCardDetailBinding
    private var onToolbarActions: OnToolbarActions? = null
    private var onBottomNavigationActions: OnBottomNavigationActions? = null
    protected var onCardDataListener: OnCardDataListener? = null
    protected val viewModel: CardDetailViewModel by viewModels()

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
        onCardDataListener?.let {
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
            }
        }
    }
}