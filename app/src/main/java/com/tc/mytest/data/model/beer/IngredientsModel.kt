package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class IngredientsModel(
    @SerializedName("hops")
    val hops: List<HopModel>? = listOf(),
    @SerializedName("malt")
    val malt: List<MaltModel>? = listOf(),
    @SerializedName("yeast")
    val yeast: String? = ""
)