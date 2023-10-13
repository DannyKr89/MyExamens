package com.example.myexamens.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myexamens.R
import com.example.myexamens.databinding.FragmentHomeBinding
import com.example.myexamens.ui.home.homework.HomeworkFragment
import com.example.myexamens.ui.home.lessonsOfDay.LessonsOfDayFragment
import com.example.myexamens.ui.home.timer.TimerFragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        requireActivity().title = "Привет, Даниил!"

        childFragmentManager
            .beginTransaction()
            .replace(R.id.timer_container, TimerFragment())
            .commit()

        childFragmentManager
            .beginTransaction()
            .replace(R.id.lessons_of_day_container, LessonsOfDayFragment())
            .commit()

        childFragmentManager
            .beginTransaction()
            .replace(R.id.homework_container, HomeworkFragment())
            .commit()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}