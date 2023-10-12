package com.example.myexamens.data

import com.example.myexamens.domain.IExamsTimer
import java.util.Calendar

class ExamsTimerRepository : IExamsTimer {

    override fun getTimeInMillis(): Long {
        val examsDate: Calendar = Calendar.getInstance()
        examsDate.apply {
            set(Calendar.YEAR, 2023)
            set(Calendar.MONTH, Calendar.OCTOBER)
            set(Calendar.DAY_OF_MONTH, 25)
            set(Calendar.HOUR_OF_DAY, 18)
            set(Calendar.MINUTE, 0)
        }
        return examsDate.timeInMillis
    }
}