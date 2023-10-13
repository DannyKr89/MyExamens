package com.example.myexamens.data

import com.example.myexamens.data.dataSource.DataSource
import com.example.myexamens.domain.IExamsTimer

class ExamsTimerRepository(private val dataSource: DataSource) : IExamsTimer {

    override fun getTimeInMillis(): Long {
        return dataSource.getTimeBeforeExams().timeInMillis
    }
}