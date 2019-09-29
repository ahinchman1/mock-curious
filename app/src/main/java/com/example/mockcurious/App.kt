package com.example.mockcurious

import android.app.Application
import android.util.Log
import timber.log.Timber

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Log.println(priority, tag, message)
        }
    }
}
