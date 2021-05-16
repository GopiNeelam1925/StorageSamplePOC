package com.techblue.retrofitpoc

import android.app.Application
import com.techblue.retrofitpoc.dI.AppComponent
import com.techblue.retrofitpoc.dI.DaggerAppComponent

class MyApplication : Application() {

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent = returnAppComponent()
        appComponent?.inject(this)
    }

    fun returnAppComponent(): AppComponent {
        return if (appComponent == null) {
//            DaggerAppComponent.builder().addApplicationContext(this).build()
            DaggerAppComponent.factory().create(this)
        } else {
            appComponent!!
        }
    }
}