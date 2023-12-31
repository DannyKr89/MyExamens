package com.example.myexamens.data.model

data class Lesson(
    val type: String,
    val title: String,
    val teacher: String,
    val timeStartHours: Int,
    val timeStartMinutes: Int,
    val timeEndHours: Int,
    val timeEndMinutes: Int,
    var isLive: Boolean,
    val image: Int?,
    val description: String? = ""
)