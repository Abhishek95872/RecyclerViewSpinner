package com.insureka.myapplication

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter

@BindingAdapter("setRangeList")
fun setRangeList(spinner: Spinner, list: List<String>) {
    val stringArray = list.map { it }.toTypedArray()
    val spinnerAdapter = ArrayAdapter(spinner.context, android.R.layout.simple_list_item_1, stringArray)
    spinner.adapter = spinnerAdapter
}
