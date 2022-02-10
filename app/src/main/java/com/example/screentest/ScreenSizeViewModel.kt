package com.example.screentest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenSizeViewModel: ViewModel() {
    // Create a LiveData with a String
    val widthSize: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}
