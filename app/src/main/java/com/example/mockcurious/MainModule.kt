package com.example.mockcurious

import com.example.mockcurious.core.DaggerArchComponentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {
    @ContributesAndroidInjector(modules = [
        UIModule::class,
        DaggerArchComponentModule::class
    ])
    fun mainActivity(): MainActivity
}

@Module(includes = [
    UsersUIModule::class
])
interface UIModule

@Module(includes = [

])
interface UsersUIModule
