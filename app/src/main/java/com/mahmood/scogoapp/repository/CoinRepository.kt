package com.mahmood.scogoapp.repository

import android.util.Log
import com.mahmood.scogoapp.model.Coin
import com.mahmood.scogoapp.network.RetrofitInstance

class CoinRepository {
    suspend fun getCoins(): List<Coin> {
        return RetrofitInstance.api.getCoins()
    }
}

