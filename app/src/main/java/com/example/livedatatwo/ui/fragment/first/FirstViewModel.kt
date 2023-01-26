package com.example.livedatatwo.ui.fragment.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedatatwo.data.model.Model

class FirstViewModel : ViewModel() {

    private val _imageLiveData = MutableLiveData<List<Model>>()
    val imageLiveData: LiveData<List<Model>> = _imageLiveData

    private val noteList = mutableListOf<Model>()

    fun addNote(number: String, title: String, description: String){
        noteList.add(Model(number = number, title = title, description = description))
        _imageLiveData.value = noteList.toList()
    }
}