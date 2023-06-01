package com.example.clickr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<imgData>>()
    var newlist = arrayListOf<imgData>()

    fun add(blog: imgData){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: imgData){
        newlist.remove(blog)
        lst.value=newlist
    }

}