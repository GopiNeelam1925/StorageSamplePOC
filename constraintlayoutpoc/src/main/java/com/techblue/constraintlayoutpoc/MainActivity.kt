package com.techblue.constraintlayoutpoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.basic_one_btn).setOnClickListener {
            startActivity(Intent(this, Basic::class.java))
        }

        findViewById<Button>(R.id.imageFilter_btn).setOnClickListener {
            startActivity(Intent(this, ImageFilterActivity::class.java))
        }

        findViewById<Button>(R.id.twittersplash_btn).setOnClickListener {
            startActivity(Intent(this, TwitterSplashActivity::class.java))
        }

        findViewById<Button>(R.id.swing_action_btn).setOnClickListener {
            startActivity(Intent(this, KeyCycleActivity::class.java))
        }

        findViewById<Button>(R.id.motion_menu_btn).setOnClickListener {
            startActivity(Intent(this, MotionMenuActivity::class.java))
        }
    }
}