package com.insureka.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableLiveData<MainViewState>()
    val viewState: LiveData<MainViewState> = _viewState

    init {
        if (_viewState.value == null) {
            _viewState.value = MainViewState()
        }
        idvDataList()
        fetchRangeList()
        fetchQuantityList()
    }

    private fun fetchRangeList() {
        val rangeList = arrayListOf<String>()
        rangeList.add("1")
        rangeList.add("2")
        rangeList.add("3")
        rangeList.add("4")
        rangeList.add("5")
        _viewState.value = _viewState.value?.copy(rangeList = rangeList)
    }

    private fun fetchQuantityList() {
        val quantityList = arrayListOf<String>()
        quantityList.add("A")
        quantityList.add("B")
        quantityList.add("C")
        quantityList.add("D")
        quantityList.add("E")
        _viewState.value = _viewState.value?.copy(quantityList = quantityList)
    }

    private fun idvDataList() {
        val idvDataList = arrayListOf<String>()
        idvDataList.add("Flood and hurricane")
        idvDataList.add("Act of God")
        idvDataList.add("Vehicle Stolen")
        idvDataList.add("Natural disaster")
        idvDataList.add("Parts and accessories")
        idvDataList.add("Flood and hurricane")
        idvDataList.add("Act of God")
        idvDataList.add("Vehicle Stolen")
        idvDataList.add("Natural disaster")
        idvDataList.add("Parts and accessories")
        idvDataList.add("Flood and hurricane")
        idvDataList.add("Act of God")
        idvDataList.add("Vehicle Stolen")
        idvDataList.add("Natural disaster")
        idvDataList.add("Parts and accessories")
        idvDataList.add("Flood and hurricane")
        idvDataList.add("Act of God")
        idvDataList.add("Vehicle Stolen")
        idvDataList.add("Natural disaster")
        idvDataList.add("Parts and accessories")
        _viewState.value = _viewState.value?.copy(idvDataList = idvDataList)
    }
}
