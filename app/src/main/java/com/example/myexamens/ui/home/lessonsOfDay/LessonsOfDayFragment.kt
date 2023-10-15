package com.example.myexamens.ui.home.lessonsOfDay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexamens.R
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.data.openInSkype
import com.example.myexamens.databinding.FragmentLessonsOfDayBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LessonsOfDayFragment : Fragment(R.layout.fragment_lessons_of_day) {


    private var _binding: FragmentLessonsOfDayBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LessonsOfDayViewModel by viewModel()
    private val adapter: LessonsOfDayAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLessonsOfDayBinding.bind(view)

        initViewModel()
        initView()
    }

    private fun initViewModel() {
        viewModel.lessonsLivedata.observe(viewLifecycleOwner) {
            showData(it)
        }
        viewModel.currentLessonLivedata.observe(viewLifecycleOwner) {
            binding.rvLessonsOfDay.scrollToPosition(it)
        }
    }

    private fun showData(list: List<Lesson>?) {
        adapter.submitList(list)
        adapter.listener = {
            openInSkype(requireContext())
        }
        binding.lessonsToday.text = String.format("%d уроков сегодня", list?.size)
    }

    private fun initView() {
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.apply {
            rvLessonsOfDay.layoutManager = linearLayoutManager
            rvLessonsOfDay.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}