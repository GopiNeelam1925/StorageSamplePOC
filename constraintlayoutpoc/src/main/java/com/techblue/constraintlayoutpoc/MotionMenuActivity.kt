package com.techblue.constraintlayoutpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity

class MotionMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_menu)

        Gravity.CENTER
    }
}