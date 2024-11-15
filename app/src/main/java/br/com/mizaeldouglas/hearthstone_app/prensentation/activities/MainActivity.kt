package br.com.mizaeldouglas.hearthstone_app.prensentation.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mizaeldouglas.hearthstone_app.R
import br.com.mizaeldouglas.hearthstone_app.databinding.ActivityMainBinding
import br.com.mizaeldouglas.hearthstone_app.prensentation.adapters.CardsAdapter
import br.com.mizaeldouglas.hearthstone_app.prensentation.viewModels.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val cardsViewModel: CardsViewModel by viewModels()
    private lateinit var cardsAdapter: CardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initialObservers()
        initialRecycleview()
    }

    private fun initialRecycleview() {
        cardsAdapter = CardsAdapter()

        binding.rvCards.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = cardsAdapter
        }
    }

    private fun initialObservers() {
        cardsViewModel.getCards()
        cardsViewModel.listCards.observe(this) { listCards ->
            if (listCards != null) {
                cardsAdapter.updateData(listCards)
                Log.i("getCards", "Cards list updated with ${listCards.size} items")
            } else {
                Log.i("getCards", "Cards list is null")
            }
        }


        cardsViewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}