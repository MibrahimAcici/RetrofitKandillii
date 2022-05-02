package com.ibrahim.retrofitkandillii.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean
) {
    data class Result(
        @SerializedName("coordinates")
        val coordinates: List<Double>,
        @SerializedName("date")
        val date: String,
        @SerializedName("date_stamp")
        val dateStamp: String,
        @SerializedName("depth")
        val depth: Double,
        @SerializedName("hash")
        val hash: String,
        @SerializedName("hash2")
        val hash2: String,
        @SerializedName("_id")
        val id: İd,
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lng")
        val lng: Double,
        @SerializedName("lokasyon")
        val lokasyon: String,
        @SerializedName("mag")
        val mag: Double,
        @SerializedName("rev")
        val rev: Any,
        @SerializedName("timestamp")
        val timestamp: Int,
        @SerializedName("title")
        val title: String
    ) {
        data class İd(
            @SerializedName("oid")
            val oid: String
        )
    }
}