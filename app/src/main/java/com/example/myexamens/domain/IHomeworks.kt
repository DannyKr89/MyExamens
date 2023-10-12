package com.example.myexamens.domain

import com.example.myexamens.data.model.Homework

interface IHomeworks {

    fun getHomeworks(): List<Homework>
}