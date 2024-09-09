package com.mahmood.scogoapp

import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mahmood.scogoapp.model.Coin

class CoinDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        val coin: Coin? = intent.getParcelableExtra("COIN_DETAILS")

        coin?.let {
            findViewById<TextView>(R.id.textCoinName).text = it.name
            findViewById<TextView>(R.id.textCoinSymbol).text = it.symbol
            findViewById<TextView>(R.id.textCoinRank).text = "Rank: ${it.rank}"
            findViewById<TextView>(R.id.textCoinPrice).text = "Price: ${it.price}"
            findViewById<TextView>(R.id.textCoinMarketCap).text = "Market Cap: ${it.marketCap}"
            findViewById<TextView>(R.id.textCoin24hVolume).text = "24h Volume: ${it.volume24h}"
            findViewById<TextView>(R.id.textCoinChange24h).text = "24h Change: ${it.change24h}%"
            findViewById<TextView>(R.id.textCoinCirculatingSupply).text = "Circulating Supply: ${it.circulatingSupply}"
            findViewById<TextView>(R.id.textCoinTotalSupply).text = "Total Supply: ${it.totalSupply}"

            // Optional Details
            findViewById<TextView>(R.id.textCoinDescription).text = it.description
            findViewById<TextView>(R.id.textCoinWebsite).text = it.website
        }
    }
}


