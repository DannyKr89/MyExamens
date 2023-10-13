package com.example.myexamens.di

import com.example.myexamens.data.ExamsTimerRepository
import com.example.myexamens.data.HomeworksRepository
import com.example.myexamens.data.LessonsOfDayRepository
import com.example.myexamens.data.dataSource.DataSource
import com.example.myexamens.domain.IExamsTimer
import com.example.myexamens.domain.IHomeworks
import com.example.myexamens.domain.ILessonsOfDay
import com.example.myexamens.ui.home.homework.HomeworkAdapter
import com.example.myexamens.ui.home.homework.HomeworkViewModel
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayAdapter
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayViewModel
import com.example.myexamens.ui.home.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { DataSource() }
}

val timerModule = module {
    single<IExamsTimer> { ExamsTimerRepository(get()) }
    viewModel { TimerViewModel(get()) }
}

val lessonsOfDayModule = module {
    single<ILessonsOfDay> { LessonsOfDayRepository(get()) }
    factory { LessonsOfDayAdapter() }
    viewModel { LessonsOfDayViewModel(get()) }
}

val homeworksModule = module {
    single<IHomeworks> { HomeworksRepository(get()) }
    factory { HomeworkAdapter() }
    viewModel { HomeworkViewModel(get()) }
}