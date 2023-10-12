package com.example.myexamens.di

import com.example.myexamens.data.ExamsTimerRepository
import com.example.myexamens.domain.IExamsTimer
import com.example.myexamens.ui.home.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val timerModule = module {
    single<IExamsTimer> { ExamsTimerRepository() }
    viewModel<TimerViewModel> { TimerViewModel(get()) }
}