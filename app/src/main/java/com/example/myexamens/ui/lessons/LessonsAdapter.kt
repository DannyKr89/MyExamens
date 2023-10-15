package com.example.myexamens.ui.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myexamens.data.model.Lesson
import com.example.myexamens.databinding.ItemAdditionalClassesBinding
import com.example.myexamens.databinding.ItemLessonsBinding

class LessonsAdapter :
    ListAdapter<Lesson, ViewHolder>(COMPARATOR) {

    var listener: ((Lesson) -> Unit)? = null

    inner class LessonsOfDayViewHolder(private val binding: ItemLessonsBinding) :
        ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            binding.apply {
                lessonTitle.text = lesson.title
                lessonTime.text = String.format(
                    "%02d:%02d - %02d:%02d",
                    lesson.timeStartHours,
                    lesson.timeStartMinutes,
                    lesson.timeEndHours,
                    lesson.timeEndMinutes
                )
                openIn.isVisible = lesson.isLive
                openIn.setOnClickListener {
                    listener?.invoke(lesson)
                }
                lesson.image?.let { lessonImage.setImageResource(it) }
                lessonTeacher.text = lesson.teacher
                if (currentList.last() == lesson) {
                    stripe.isVisible = false
                }
                isOnlinePoint.isVisible = lesson.isLive
            }
        }
    }

    inner class ClassesViewHolder(private val binding: ItemAdditionalClassesBinding) :
        ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            binding.apply {
                lessonTitle.text = lesson.title
                lessonTime.text = String.format(
                    "%02d:%02d - %02d:%02d",
                    lesson.timeStartHours,
                    lesson.timeStartMinutes,
                    lesson.timeEndHours,
                    lesson.timeEndMinutes
                )
                lesson.image?.let { lessonImage.setImageResource(it) }
                lessonTeacher.text = lesson.teacher
                if (currentList.last() == lesson) {
                    stripe.isVisible = false
                }
                lessonDescription.text = lesson.description
                isOnlinePoint.isVisible = lesson.isLive
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

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            "Урок" -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> {
                val binding =
                    ItemLessonsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LessonsOfDayViewHolder(binding)
            }

            else -> {
                val binding = ItemAdditionalClassesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ClassesViewHolder(binding)
            }
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                (holder as LessonsOfDayViewHolder).bind(getItem(position))
            }

            else -> {
                (holder as ClassesViewHolder).bind(getItem(position))
            }
        }
    }
}