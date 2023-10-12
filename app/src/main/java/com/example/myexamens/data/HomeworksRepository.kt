package com.example.myexamens.data

import com.example.myexamens.data.model.Homework
import com.example.myexamens.domain.IHomeworks
import java.util.Calendar

class HomeworksRepository : IHomeworks {

    private val list = listOf(
        Homework("Android разработка",
            "Напишите приложение, которое состоит из двух экранов, с табами снизу.",
            Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }),
        Homework("Математика", "Вычеслить функцию", Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, (1..30).random())
        }),
        Homework(
            "Русский",
            "Написать сочинение на тему как я провел лето",
            Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }),
        Homework("Химия",
            "Свойства спиртов, альдегидов, кислот, сложных эфиров, фенола",
            Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }),
        Homework("Физика",
            "В таблице представлены данные о положении шарика, прикреплённого к пружине и колеблющегося вдоль горизонтальной оси  в различные моменты времени.",
            Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            }),
        Homework("История",
            "Выучить стихотворение",
            Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, (1..30).random())
            })
    )

    override fun getHomeworks(): List<Homework> {
        return list
    }
}