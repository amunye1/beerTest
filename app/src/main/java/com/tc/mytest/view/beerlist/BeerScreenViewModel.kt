package com.tc.mytest.view.beerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //Mutable State Flow to store the data
    private val _beers = MutableLiveData<List<BeerItemModel>>()
    val beers: LiveData<List<BeerItemModel>> = _beers


    //Initialising the API call request to fetch the data
    init {
        getBeers()
    }


    fun getBeers() {
        viewModelScope.launch {
            // Call the repository to fetch the list of beers
            val response = repository.getBeers()
            // Update the state with the list of beers
            _beers.value = response ?: emptyList()


        }
    }
}