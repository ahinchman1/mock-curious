package com.example.mockcurious.core

import android.app.Application
import okhttp3.OkHttpClient
import javax.inject.Singleton
import dagger.Provides
import android.preference.PreferenceManager
import android.content.SharedPreferences
import dagger.Module

@Module
class NetWorkModule// Constructor needs one parameter to instantiate.
    (private var mBaseUrl: String) {

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application):
    // Application reference must come from AppModule.class
            SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    // TODO provides retrofit, gson, and okhttp
}