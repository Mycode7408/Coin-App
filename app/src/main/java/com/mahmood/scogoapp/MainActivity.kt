package com.mahmood.scogoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahmood.scogoapp.databinding.ActivityMainBinding
import com.mahmood.scogoapp.model.Coin
import com.mahmood.scogoapp.repository.CoinRepository
import com.mahmood.scogoapp.ui.CoinAdapter
import com.mahmood.scogoapp.viewmodel.CoinViewModel
import com.mahmood.scogoapp.viewmodel.CoinViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coinAdapter: CoinAdapter

    private val coinViewModel: CoinViewModel by viewModels {
        CoinViewModelFactory(CoinRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeData()

        // Fetch data from API
        coinViewModel.fetchCoins()

        // Swipe-to-refresh functionality
        binding.swipeRefresh.setOnRefreshListener {
            coinViewModel.fetchCoins()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun setupRecyclerView() {
        coinAdapter = CoinAdapter { coin ->
            // Handle item click here
            val intent = Intent(this, CoinDetailActivity::class.java).apply {
                putExtra("COIN_DETAILS", coin)
            }
            startActivity(intent)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = coinAdapter
        }
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = coinViewModel.coinList.value?.filter { coin ->
                    coin.name.contains(newText ?: "", ignoreCase = true)
                }
                coinAdapter.submitList(filteredList)
                return true
            }
        })
    }



    private fun observeData() {
        coinViewModel.coinList.observe(this) { coins ->
            if (coins.isNotEmpty()) {
                coinAdapter.submitList(coins)
                Log.d("MainActivity", "Coins updated: $coins")

            } else {
                Log.d("MainActivity", "Coin list is empty")
            }
        }
    }
}
