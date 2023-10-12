package com.example.myexamens.di

import com.example.myexamens.data.ExamsTimerRepository
import com.example.myexamens.data.LessonsOfDayRepository
import com.example.myexamens.domain.IExamsTimer
import com.example.myexamens.domain.ILessonsOfDay
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayAdapter
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayViewModel
import com.example.myexamens.ui.home.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val timerModule = module {
    single<IExamsTimer> { ExamsTimerRepository() }
    viewModel<TimerViewModel> { TimerViewModel(get()) }
}

val lessonsOfDayModule = module {
    single<ILessonsOfDay> { LessonsOfDayRepository() }
    factory<LessonsOfDayAdapter> { LessonsOfDayAdapter() }
    viewModel<LessonsOfDayViewModel> { LessonsOfDayViewModel(get()) }
}