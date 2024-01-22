package com.example.webeteer.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.webeteer.util.SingleLiveEvent


abstract class BaseViewModel : ViewModel() {
    val toolbarTitle = MutableLiveData<String>()
    val toastMessage = SingleLiveEvent<String>()
}