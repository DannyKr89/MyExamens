package com.example.myexamens.data

import com.example.myexamens.data.dataSource.DataSource
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.domain.ILessonsOfDay
import java.util.Calendar

class LessonsOfDayRepository(dataSource: DataSource) : ILessonsOfDay {

    private val list = dataSource.getLessons()

    override fun getLessons(): List<Lesson> {
        return list
    }

    override fun getCurrentLessons(): Int {
        var lesson = 0
        val calendar = Calendar.getInstance()
        var lastEndTime = Calendar.getInstance()
        list.forEach {

            val startTime = convertToCalendarTime(it.timeStartHours, it.timeStartMinutes)
            val endTime = convertToCalendarTime(it.timeEndHours, it.timeEndMinutes)

            if (calendar.after(startTime) && calendar.before(endTime)) {
                lesson = list.indexOf(it)
                it.isLive = true
            } else if (calendar.after(lastEndTime) && calendar.before(startTime)) {
                lesson = list.indexOf(it)
            } else if (calendar.after(lastEndTime)) {
                lesson = list.indexOf(it)
            }
            lastEndTime = endTime

        }
        return lesson
    }

    private fun convertToCalendarTime(hour: Int, minute: Int): Calendar {
        return Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }
    }
}