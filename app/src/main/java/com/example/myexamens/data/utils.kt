package com.example.myexamens.data

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun openInSkype(context: Context) {
    val manager = context.packageManager
    val intent = manager.getLaunchIntentForPackage("com.skype.raider")
    intent?.addCategory(Intent.CATEGORY_LAUNCHER)
    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "Установите Skype", Toast.LENGTH_SHORT).show()
    }
}