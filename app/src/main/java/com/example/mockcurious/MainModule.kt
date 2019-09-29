package com.example.mockcurious

import com.example.mockcurious.core.DaggerArchComponentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {
    @ContributesAndroidInjector(modules = [
        DaggerArchComponentModule::class
    ])
    fun mainActivity(): MainActivity
}
