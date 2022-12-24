package com.javatar.demoplatzi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.listener.OnCardDataListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnCardDataListener {

    private val cardItemUiState = CardItemUiState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getData() = cardItemUiState
}