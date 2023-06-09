package com.rzrasel.rztutorial.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rzrasel.rztutorial.model.DashboardMenuModel
import com.rzrasel.rztutorial.network.DataResource
import com.rzrasel.rztutorial.repository.DashboardMenuRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: DashboardMenuRepository) :
    ViewModel() {
    private val _response: MutableLiveData<DataResource<ArrayList<DashboardMenuModel>>> =
        MutableLiveData()
    val response: LiveData<DataResource<ArrayList<DashboardMenuModel>>>
        get() = _response

    fun getData(context: Context) = viewModelScope.launch {
        _response.value = repository.getMenuData(context)
    }

    /*private val _response: MutableLiveData<ArrayList<DashboardMenuModel>> = MutableLiveData()
    val response: LiveData<ArrayList<DashboardMenuModel>>
        get() = _response

    fun getData() = viewModelScope.launch {
        _response.value = repository.getMenuData()
    }*/
}