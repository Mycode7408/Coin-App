package com.mahmood.scogoapp.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.mahmood.scogoapp.model.Coin
import com.mahmood.scogoapp.repository.CoinRepository
import kotlinx.coroutines.launch

class CoinViewModel(private val repository: CoinRepository) : ViewModel() {

    private val _coinList = MutableLiveData<List<Coin>>()
    val coinList: LiveData<List<Coin>> = _coinList

    fun fetchCoins() {
        viewModelScope.launch {
            try {
                val coins = repository.getCoins()
                _coinList.value = coins
                Log.d("CoinViewModel", "Fetched coins: $coins")

            } catch (e: Exception) {
                e.printStackTrace() // Log any error that occurs
                Log.e("CoinViewModel", "Error fetching coins", e)

            }
        }
    }
}

class CoinViewModelFactory(private val repository: CoinRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinViewModel::class.java)) {
            return CoinViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

