package com.tc.mytest.view.beerdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _beerDetails = MutableLiveData<BeerItemModel>()
    val beerDetails: LiveData<BeerItemModel> = _beerDetails

    fun getBeerItem(beerId: Int) {
        viewModelScope.launch {
            val result = repository.getBeerItem(beerId)[0]
            _beerDetails.value = result
        }
    }

}