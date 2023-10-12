package com.example.myexamens.ui.home.lessonsOfDay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.domain.ILessonsOfDay
import java.util.Calendar

class LessonsOfDayViewModel(private val repository: ILessonsOfDay) : ViewModel() {

    private val _lessonsLivedata: MutableLiveData<List<Lesson>> = MutableLiveData<List<Lesson>>()
    val lessonsLivedata: LiveData<List<Lesson>> = _lessonsLivedata

    private val _currentLessonLivedata: MutableLiveData<Int> = MutableLiveData<Int>()
    val currentLessonLivedata: LiveData<Int> = _currentLessonLivedata


    init {
        getExamsTimer()
    }

    private fun getExamsTimer() {
        _lessonsLivedata.postValue(repository.getLessons())
        scrollToLesson()
    }

    private fun scrollToLesson() {
        val currentHour = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
        _currentLessonLivedata.postValue(repository.getCurrentLessons(currentHour))
    }
}