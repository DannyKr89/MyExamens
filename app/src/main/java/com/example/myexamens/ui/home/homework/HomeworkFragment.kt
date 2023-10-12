package com.example.myexamens.ui.home.homework

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexamens.R
import com.example.myexamens.databinding.FragmentHomeworkBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeworkFragment : Fragment(R.layout.fragment_homework) {
    private var _binding: FragmentHomeworkBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeworkViewModel by viewModel()
    private val adapter: HomeworkAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeworkBinding.bind(view)

        initViewModel()
        initView()
    }

    private fun initViewModel() {
        viewModel.homeworkLivedata.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initView() {
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.apply {
            rvHomework.layoutManager = linearLayoutManager
            rvHomework.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}