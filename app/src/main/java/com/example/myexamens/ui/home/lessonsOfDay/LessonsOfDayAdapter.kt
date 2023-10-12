package com.example.myexamens.ui.home.lessonsOfDay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.databinding.ItemLessonBinding

class LessonsOfDayAdapter :
    ListAdapter<Lesson, LessonsOfDayAdapter.LessonsOfDayViewHolder>(COMPARATOR) {

    class LessonsOfDayViewHolder(private val binding: ItemLessonBinding) :
        ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            binding.apply {
                lessonTitle.text = lesson.title
                lessonTime.text = String.format("%02d:%02d", lesson.timeHours, lesson.timeMinutes)
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Lesson>() {
            override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
                return false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsOfDayViewHolder {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonsOfDayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonsOfDayViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}