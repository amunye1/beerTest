package com.tc.mytest.data.repository

import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiRequest: ApiRequest
) : Repository {

    override suspend fun getBeers(): List<BeerItemModel> = apiRequest.getBeers()
    override suspend fun getBeerItem(id: Int): List<BeerItemModel> = apiRequest.getBeerItem(id)

}