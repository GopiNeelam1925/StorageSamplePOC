package com.techblue.retrofitpoc.dI

import com.techblue.retrofitpoc.MainActivity
import com.techblue.retrofitpoc.MyApplication
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [FirstModule::class, NetworkModule::class])
interface AppComponent {


    fun inject(mainActivity: MainActivity)
    fun inject(myApplication: MyApplication)

//    @Component.Builder
//    interface AppComponentBuilder{
//
//        @BindsInstance
//        fun addApplicationContext(myApplication: MyApplication):AppComponentBuilder
//
//        fun build():AppComponent
//    }

    @Component.Factory
    interface AppComponentFactory {

        fun create(@BindsInstance myApplication: MyApplication): AppComponent
    }
}