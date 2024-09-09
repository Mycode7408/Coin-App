package com.mahmood.scogoapp.model

import android.os.Parcel
import android.os.Parcelable

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val price: String, // Add price field
    val marketCap: String, // Add marketCap field
    val volume24h: String, // Add volume24h field
    val change24h: String, // Add change24h field
    val circulatingSupply: String, // Add circulatingSupply field
    val totalSupply: String, // Add totalSupply field
    val description: String?, // Add description field (nullable)
    val website: String? // Add website field (nullable)
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(symbol)
        parcel.writeInt(rank)
        parcel.writeString(price) // Write price
        parcel.writeString(marketCap) // Write marketCap
        parcel.writeString(volume24h) // Write volume24h
        parcel.writeString(change24h) // Write change24h
        parcel.writeString(circulatingSupply) // Write circulatingSupply
        parcel.writeString(totalSupply) // Write totalSupply
        parcel.writeString(description) // Write description
        parcel.writeString(website) // Write website
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coin> {
        override fun createFromParcel(parcel: Parcel): Coin {
            return Coin(parcel)
        }

        override fun newArray(size: Int): Array<Coin?> {
            return arrayOfNulls(size)
        }
    }
}
