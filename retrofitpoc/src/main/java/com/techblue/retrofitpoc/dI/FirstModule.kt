package com.techblue.retrofitpoc.dI

import android.content.Context
import android.content.SharedPreferences
import com.techblue.retrofitpoc.MyApplication
import dagger.Module
import dagger.Provides

@Module
class FirstModule {


    @AppScope
    @Provides
    fun provideContext(myApplication: MyApplication): Context {
        return myApplication
    }

    @AppScope
    @SharedPrefQualifier
    @Provides
    fun provideSharePreference(context: Context): SharedPreferences {
        return context.getSharedPreferences("Sample", Context.MODE_PRIVATE)
    }
}