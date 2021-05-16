package com.techblue.retrofitpoc

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.techblue.retrofitpoc.dI.SharedPrefQualifier
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    @SharedPrefQualifier
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).returnAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("sharedPreferences", "${sharedPreferences.toString()}")

//ContextCompat.startForegroundService()
    }

    @Inject
    fun getContextHere(context: Context){
        Log.e("context", "${context.toString()}")
        Log.e("context", "called by dagger")
    }
}