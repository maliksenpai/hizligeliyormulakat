package com.labradorshub.hzlgeliyormlakat.ui.detail

import androidx.lifecycle.MutableLiveData
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseViewModel

class DetailViewModel : BaseViewModel() {

    var buy = MutableLiveData<Boolean>()

    fun init(){
        buy.value=false
    }

    fun buy(){
        buy.value=true
    }

}