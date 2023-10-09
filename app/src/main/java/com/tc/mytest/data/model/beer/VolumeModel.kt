package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class VolumeModel(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Int? = 0
)