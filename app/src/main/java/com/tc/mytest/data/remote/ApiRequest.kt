package com.tc.mytest.data.remote

import com.tc.mytest.data.model.beer.BeerItemModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {

    @GET(ApiDetails.BEER)
    suspend fun getBeers(): List<BeerItemModel>

    @GET(ApiDetails.BEER_ITEM)
    suspend fun getBeerItem(@Path("id") id: Int): List<BeerItemModel>

}