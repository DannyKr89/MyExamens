package com.example.myexamens.di

import com.example.myexamens.data.dataSource.DataSource
import com.example.myexamens.data.repository.ExamsTimerRepository
import com.example.myexamens.data.repository.HomeworksRepository
import com.example.myexamens.data.repository.LessonsOfDayRepository
import com.example.myexamens.domain.IExamsTimer
import com.example.myexamens.domain.IHomeworks
import com.example.myexamens.domain.ILessonsOfDay
import com.example.myexamens.ui.home.homework.HomeworkAdapter
import com.example.myexamens.ui.home.homework.HomeworkViewModel
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayAdapter
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayViewModel
import com.example.myexamens.ui.home.timer.TimerViewModel
import com.example.myexamens.ui.lessons.LessonsAdapter
import com.example.myexamens.ui.lessons.LessonsViewModel
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
    factory { LessonsOfDayAdapter() }
    single<ILessonsOfDay> { LessonsOfDayRepository(get()) }
    viewModel { LessonsOfDayViewModel(get()) }
}

val lessonsModule = module {
    factory { LessonsAdapter() }
    single<ILessonsOfDay> { LessonsOfDayRepository(get()) }
    viewModel { LessonsViewModel(get()) }
}

val homeworksModule = module {
    single<IHomeworks> { HomeworksRepository(get()) }
    factory { HomeworkAdapter() }
    viewModel { HomeworkViewModel(get()) }
}