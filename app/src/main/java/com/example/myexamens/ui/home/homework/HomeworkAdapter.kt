package com.example.myexamens.ui.home.homework

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myexamens.data.model.Homework
import com.example.myexamens.databinding.ItemHomeworkBinding
import java.util.Calendar
import java.util.concurrent.TimeUnit

class HomeworkAdapter :
    ListAdapter<Homework, HomeworkAdapter.HomeworkViewHolder>(COMPARATOR) {

    class HomeworkViewHolder(private val binding: ItemHomeworkBinding) :
        ViewHolder(binding.root) {

        fun bind(homework: Homework) {
            binding.apply {
                homeworkTitle.text = homework.title
                homeworkDescription.text = homework.description
                val daysInMillis =
                    (homework.deadline.timeInMillis - Calendar.getInstance().timeInMillis)
                val days = TimeUnit.MILLISECONDS.toDays(daysInMillis)
                when (days) {
                    in 0..2 -> {
                        homeworkTime.setTextColor(Color.rgb(255, 0, 0))
                        ivTime.setColorFilter(Color.rgb(255, 0, 0))
                    }

                    in 3..6 -> {
                        homeworkTime.setTextColor(Color.rgb(255, 255, 0))
                        ivTime.setColorFilter(Color.rgb(255, 255, 0))
                    }

                    in 7..30 -> {
                        homeworkTime.setTextColor(Color.rgb(0, 255, 0))
                        ivTime.setColorFilter(Color.rgb(0, 255, 0))
                    }

                    else -> {
                        homeworkTime.isVisible = false
                    }
                }
                homeworkTime.text = String.format("%d д.", days)
                homework.image?.let { homeworkImage.setImageResource(it) }
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Homework>() {
            override fun areItemsTheSame(oldItem: Homework, newItem: Homework): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Homework, newItem: Homework): Boolean {
                return false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val binding =
            ItemHomeworkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeworkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}