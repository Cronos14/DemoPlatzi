package com.javatar.demoplatzi.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.javatar.demoplatzi.CardItemUiState
import com.javatar.demoplatzi.R
import com.javatar.demoplatzi.databinding.ActivityMainBinding
import com.javatar.demoplatzi.listener.OnBottomNavigationActions
import com.javatar.demoplatzi.listener.OnCardDataListener
import com.javatar.demoplatzi.listener.OnToolbarActions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnToolbarActions, OnBottomNavigationActions,
    OnCardDataListener {

    private lateinit var binding: ActivityMainBinding
    private val cardItemUiState = CardItemUiState()

    private val navHostDashboard by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as NavHostFragment
    }

    private val navController by lazy {
        navHostDashboard.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(true)
        }
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun isEnabledIconBack(isEnabled: Boolean) {
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(isEnabled)
            setDisplayHomeAsUpEnabled(isEnabled)
        }
    }

    override fun hideBottomNavigation() {
        binding.bottomNavView.visibility = View.GONE
    }

    override fun showBottomNavigation() {
        binding.bottomNavView.visibility = View.VISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun getData() = cardItemUiState
}