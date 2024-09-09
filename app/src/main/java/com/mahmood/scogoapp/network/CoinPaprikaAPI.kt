package com.mahmood.scogoapp.network

import com.mahmood.scogoapp.model.Coin
import retrofit2.http.GET

interface CoinPaprikaApiService {
    @GET("v1/coins")
    suspend fun getCoins(): List<Coin>
}
