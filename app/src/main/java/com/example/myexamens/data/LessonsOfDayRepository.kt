package com.example.myexamens.data

import com.example.myexamens.data.model.Lesson
import com.example.myexamens.domain.ILessonsOfDay

class LessonsOfDayRepository : ILessonsOfDay {

    private val list = listOf(
        Lesson("Математика", "", 10, 0),
        Lesson("Русский", "", 12, 0),
        Lesson("Физика", "", 14, 0),
        Lesson("Химия", "", 16, 0),
        Lesson("Физ-ра", "", 18, 0),
    )

    override fun getLessons(): List<Lesson> {
        return list
    }

    override fun getCurrentLessons(hour: Int): Int {
        var lesson = 0
        list.forEach {
            when (it.timeHours - hour) {
                0 -> {
                    lesson = list.indexOf(it)
                }

                1 -> {
                    lesson = list.indexOf(it)
                }

                !in 0..24 -> {
                    lesson = list.indexOf(it)
                }
            }
        }
        return lesson
    }
}