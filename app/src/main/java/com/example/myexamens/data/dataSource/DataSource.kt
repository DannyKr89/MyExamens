package com.example.myexamens.data.dataSource

import com.example.myexamens.R
import com.example.myexamens.data.model.Homework
import com.example.myexamens.data.model.Lesson
import java.util.Calendar

class DataSource {

    private val imagesMap = mapOf<String, Int>(
        "Математика" to R.drawable.math,
        "Русский" to R.drawable.russian_language,
        "Физика" to R.drawable.physics,
        "Химия" to R.drawable.chemistry,
        "Физкультура" to R.drawable.running,
        "Android разработка" to R.drawable.android,
        "История" to R.drawable.history,

        )

    fun getTimeBeforeExams(): Calendar {
        return Calendar.getInstance().apply {
            set(Calendar.YEAR, 2023)
            set(Calendar.MONTH, Calendar.DECEMBER)
            set(Calendar.DAY_OF_MONTH, 20)
            set(Calendar.HOUR_OF_DAY, 18)
            set(Calendar.MINUTE, 0)
        }
    }

    fun getLessons(): List<Lesson> {
        return listOf(
            Lesson("Математика", 8, 0, 8, 45, false, imagesMap.get("Математика")),
            Lesson("Русский", 9, 0, 9, 45, false, imagesMap.get("Русский")),
            Lesson("Физика", 10, 0, 12, 0, false, imagesMap.get("Физика")),
            Lesson("Химия", 13, 0, 14, 30, false, imagesMap.get("Химия")),
            Lesson("Физкультура", 15, 0, 17, 0, false, imagesMap.get("Физкультура")),
            Lesson("Android разработка", 18, 0, 21, 0, false, imagesMap.get("Android разработка")),
        )
    }

    fun getHomeworks(): List<Homework> {
        return listOf(
            Homework(
                "Android разработка",
                "Напишите приложение, которое состоит из двух экранов, с табами снизу.",
                Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_YEAR, (1..30).random())
                }, imagesMap.get("Android разработка")
            ),
            Homework("Математика", "Вычеслить функцию", Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }, imagesMap.get("Математика")),
            Homework("Русский",
                "Написать сочинение на тему как я провел лето",
                Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_YEAR, (1..30).random())
                }, imagesMap.get("Русский")),
            Homework("Химия",
                "Свойства спиртов, альдегидов, кислот, сложных эфиров, фенола",
                Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_YEAR, (1..30).random())
                }, imagesMap.get("Химия")),
            Homework("Физика",
                "В таблице представлены данные о положении шарика, прикреплённого к пружине и колеблющегося вдоль горизонтальной оси  в различные моменты времени.",
                Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_YEAR, (1..30).random())
                }, imagesMap.get("Физика")),
            Homework("История", "Выучить стихотворение", Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }, imagesMap.get("История"))
        )
    }
}