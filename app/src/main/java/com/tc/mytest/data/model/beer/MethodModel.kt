package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class MethodModel(
    @SerializedName("fermentation")
    val fermentation: FermentationModel? = FermentationModel(),
    @SerializedName("twist")
    val twist: String? = ""
)