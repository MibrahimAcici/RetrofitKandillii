package com.ibrahim.retrofitkandillii.model

import com.google.gson.annotations.SerializedName

data class PlacesResponse(

	@field:SerializedName("result")
	val result: List<PlaceItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)