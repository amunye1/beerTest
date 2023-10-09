package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName
import com.tc.mytest.data.model.beer.TempModel

data class FermentationModel(
    @SerializedName("temp")
    val temp: TempModel? = TempModel()
)