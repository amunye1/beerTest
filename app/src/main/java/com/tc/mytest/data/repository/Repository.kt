package com.tc.mytest.data.repository

import com.tc.mytest.data.model.beer.BeerItemModel

interface Repository {

    suspend fun getBeers(): List<BeerItemModel>

    suspend fun getBeerItem(id: Int): List<BeerItemModel>

}