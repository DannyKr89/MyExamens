package com.example.myexamens.ui.home.homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myexamens.data.model.Homework
import com.example.myexamens.domain.IHomeworks

class HomeworkViewModel(private val repository: IHomeworks) : ViewModel() {

    private val _homeworkLivedata: MutableLiveData<List<Homework>> =
        MutableLiveData<List<Homework>>()
    val homeworkLivedata: LiveData<List<Homework>> = _homeworkLivedata

    init {
        getHomeworks()
    }

    private fun getHomeworks() {
        _homeworkLivedata.postValue(repository.getHomeworks())
    }
}