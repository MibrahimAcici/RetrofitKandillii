package com.ibrahim.retrofitkandillii.model

import com.google.gson.annotations.SerializedName

data class PlaceItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("rev")
	val rev: Any? = null,

	@field:SerializedName("hash2")
	val hash2: String? = null,

	@field:SerializedName("lng")
	val lng: Double? = null,

	@field:SerializedName("lokasyon")
	val lokasyon: String? = null,

	@field:SerializedName("coordinates")
	val coordinates: List<Double?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("date_stamp")
	val dateStamp: String? = null,

	@field:SerializedName("mag")
	val mag: Double? = null,

	@field:SerializedName("depth")
	val depth: Double? = null,

	@field:SerializedName("_id")
	val id: Id? = null,

	@field:SerializedName("lat")
	val lat: Double? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: Int? = null
)