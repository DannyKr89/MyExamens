package com.example.myexamens.ui.home.timer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myexamens.R
import com.example.myexamens.databinding.FragmentTimerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimerFragment : Fragment(R.layout.fragment_timer) {

    private var _binding: FragmentTimerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TimerViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTimerBinding.bind(view)

        viewModel.livedata.observe(viewLifecycleOwner) {
            binding.apply {
                timerDaysFirst.text = it[0]
                timerDaysSecond.text = it[1]
                timerHoursFirst.text = it[2]
                timerHoursSecond.text = it[3]
                timerMinuteFirst.text = it[4]
                timerMinuteSecond.text = it[5]
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}