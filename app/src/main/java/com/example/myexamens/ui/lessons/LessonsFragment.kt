package com.example.myexamens.ui.lessons


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myexamens.R
import com.example.myexamens.databinding.FragmentLessonsBinding

class LessonsFragment : Fragment(R.layout.fragment_lessons) {

    private var _binding: FragmentLessonsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLessonsBinding.bind(view)
        requireActivity().title = "Уроки"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}