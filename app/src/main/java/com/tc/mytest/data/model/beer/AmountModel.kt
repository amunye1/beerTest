package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class AmountModel(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Double? = 0.0
)