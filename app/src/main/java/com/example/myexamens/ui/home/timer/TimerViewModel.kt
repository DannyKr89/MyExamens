package com.example.myexamens.ui.home.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myexamens.domain.IExamsTimer
import java.util.Calendar

class TimerViewModel(private val repository: IExamsTimer) : ViewModel() {

    private val _livedata: MutableLiveData<String> = MutableLiveData<String>()
    val livedata: LiveData<String> = _livedata

    init {
        getExamsTimer()
    }

    private fun getExamsTimer() {
        val currentTime = Calendar.getInstance()

        _livedata.postValue("00:00:00")

        val countDownTimer = repository.getTimeInMillis() - currentTime.timeInMillis

        if (countDownTimer > 0) {
            object : CountDownTimer(countDownTimer, 1000) {
                override fun onTick(millisUntillFinish: Long) {
                    val seconds = (millisUntillFinish / 1000) % 60
                    val minutes = ((millisUntillFinish / 1000) % 3600) / 60
                    val hours = (millisUntillFinish / 1000) / 3600 % 24
                    val days = (millisUntillFinish / 1000) / 86400
                    val result =
                        String.format("%d д. %02d:%02d:%02d", days, hours, minutes, seconds)
                    _livedata.postValue(result)
                }

                override fun onFinish() {
                    _livedata.postValue("Началось!")
                }
            }.start()
        } else {
            _livedata.postValue("АЛАРМ!!Они уже идут!!!")
        }
    }

}