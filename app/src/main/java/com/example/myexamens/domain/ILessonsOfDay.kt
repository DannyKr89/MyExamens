package com.example.myexamens.domain

import com.example.myexamens.data.model.Lesson

interface ILessonsOfDay {

    fun getLessons(): List<Lesson>
    fun getCurrentLessons(hour: Int): Int
}