package com.tc.mytest.data.model.beer


import com.google.gson.annotations.SerializedName
import com.tc.mytest.data.model.beer.BoilVolumeModel
import com.tc.mytest.data.model.beer.IngredientsModel
import com.tc.mytest.data.model.beer.MethodModel
import com.tc.mytest.data.model.beer.VolumeModel

data class BeerItemModel(
    @SerializedName("abv")
    val abv: Double? = 0.0,
    @SerializedName("attenuation_level")
    val attenuationLevel: Double? = 0.0,
    @SerializedName("boil_volume")
    val boilVolume: BoilVolumeModel? = BoilVolumeModel(),
    @SerializedName("brewers_tips")
    val brewersTips: String? = "",
    @SerializedName("contributed_by")
    val contributedBy: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("ebc")
    val ebc: Int? = 0,
    @SerializedName("first_brewed")
    val firstBrewed: String? = "",
    @SerializedName("food_pairing")
    val foodPairing: List<String>? = listOf(),
    @SerializedName("ibu")
    val ibu: Double? = 0.0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image_url")
    val imageUrl: String? = "",
    @SerializedName("ingredients")
    val ingredients: IngredientsModel? = IngredientsModel(),
    @SerializedName("method")
    val method: MethodModel? = MethodModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("ph")
    val ph: Double? = 0.0,
    @SerializedName("srm")
    val srm: Double? = 0.0,
    @SerializedName("tagline")
    val tagline: String? = "",
    @SerializedName("target_fg")
    val targetFg: Int? = 0,
    @SerializedName("target_og")
    val targetOg: Double? = 0.0,
    @SerializedName("volume")
    val volume: VolumeModel? = VolumeModel()
)