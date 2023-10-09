package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class BoilVolumeModel(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Int? = 0
)