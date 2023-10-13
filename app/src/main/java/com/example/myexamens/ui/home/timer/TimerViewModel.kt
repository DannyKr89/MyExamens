package com.example.myexamens.ui.home.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myexamens.domain.IExamsTimer
import java.util.Calendar

class TimerViewModel(private val repository: IExamsTimer) : ViewModel() {

    private val _livedata: MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    val livedata: LiveData<List<String>> = _livedata

    init {
        getExamsTimer()
    }

    private fun getExamsTimer() {
        val currentTime = Calendar.getInstance()

        val countDownTimer = repository.getTimeInMillis() - currentTime.timeInMillis

        if (countDownTimer > 0) {
            object : CountDownTimer(countDownTimer, 1000) {
                override fun onTick(millisUntillFinish: Long) {
                    val minutes = ((millisUntillFinish / 1000) % 3600) / 60
                    val hours = (millisUntillFinish / 1000) / 3600 % 24
                    val days = (millisUntillFinish / 1000) / 86400

                    val result = listOf(
                        (days / 10).toInt().toString(),
                        (days % 10).toString(),
                        (hours / 10).toInt().toString(),
                        (hours % 10).toString(),
                        (minutes / 10).toInt().toString(),
                        (minutes % 10).toString()
                    )
                    _livedata.postValue(result)
                }

                override fun onFinish() {
                    _livedata.postValue(listOf("Началось!"))
                }
            }.start()
        } else {
            _livedata.postValue(listOf("АЛАРМ!!Они уже идут!!!"))
        }
    }

}