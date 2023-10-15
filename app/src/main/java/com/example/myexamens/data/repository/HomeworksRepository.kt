package com.example.myexamens.data.repository

import com.example.myexamens.data.dataSource.DataSource
import com.example.myexamens.data.model.Homework
import com.example.myexamens.domain.IHomeworks

class HomeworksRepository(private val dataSource: DataSource) : IHomeworks {

    override fun getHomeworks(): List<Homework> {
        return dataSource.getHomeworks()
    }
}