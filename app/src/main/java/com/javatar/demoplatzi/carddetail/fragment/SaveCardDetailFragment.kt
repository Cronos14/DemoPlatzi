package com.javatar.demoplatzi.carddetail.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.javatar.demoplatzi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveCardDetailFragment : CardDetailFragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save_card, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                onCardDataListener?.let { data ->
                    data.getData().card?.let { card ->
                        viewModel.saveCard(card)
                        findNavController().navigateUp()
                        Toast.makeText(
                            context,
                            resources.getText(R.string.message_add_card),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}