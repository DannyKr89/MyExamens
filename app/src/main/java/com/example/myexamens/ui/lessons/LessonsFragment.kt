package com.example.myexamens.ui.lessons


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexamens.R
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.data.openInSkype
import com.example.myexamens.databinding.FragmentLessonsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LessonsFragment : Fragment(R.layout.fragment_lessons) {

    private var _binding: FragmentLessonsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LessonsViewModel by viewModel()
    private val adapter: LessonsAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLessonsBinding.bind(view)
        requireActivity().title = "Уроки"

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
    }

    private fun initView() {
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

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