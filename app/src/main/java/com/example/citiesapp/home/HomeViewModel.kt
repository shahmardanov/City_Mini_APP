package com.example.citiesapp.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citiesapp.model.Data
import com.example.citiesapp.repo.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CityRepository) : ViewModel() {




    val data = MutableLiveData<List<Data>>()
    val load = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    init {
        getCities()
    }


    fun getCities(){
        load.value = true
        viewModelScope.launch {
            try {
                val response = repository.getAllCities()
                if (response.isSuccessful && response.body()!=null) {
                    Log.e("data",response.errorBody().toString())
                    data.value = response.body()!!.data
                } else {
                    error.value = "Error getting cities"
                    Log.e("errordata",response.errorBody().toString())
                }
            } catch (e: Exception) {
                error.value = e.localizedMessage.toString()
            }
        }
    }

}