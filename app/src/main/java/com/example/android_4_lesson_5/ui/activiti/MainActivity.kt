package com.example.android_4_lesson_5.ui.activiti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android4lesson5.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}