package com.example.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.PopularList
import com.example.movieapp.model.Results
import com.example.movieapp.service.RetroService
import com.example.movieapp.service.RetronIstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainWM : ViewModel() {

    private var rvList: MutableLiveData<PopularList> = MutableLiveData()

    fun rvObserver(): MutableLiveData<PopularList> {
        return rvList
    }

    fun callApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetronIstance.getRetronIstace().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("c29dc1d9671fdb7f6563e74b343aee50", "en", 1)
            rvList.postValue(response)
        }
    }
}


