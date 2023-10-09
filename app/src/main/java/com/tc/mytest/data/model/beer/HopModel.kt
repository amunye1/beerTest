package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName

data class HopModel(
    @SerializedName("add")
    val add: String? = "",
    @SerializedName("amount")
    val amount: AmountModel? = AmountModel(),
    @SerializedName("attribute")
    val attribute: String? = "",
    @SerializedName("name")
    val name: String? = ""
)