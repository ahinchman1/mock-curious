package com.example.mockcurious

import android.app.Activity
import android.app.Application
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

open class App : Application() { //, HasActivityInjector {

    lateinit var appComponent: AppComponent

    @Inject
    var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>? = null

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()

        /*appComponent = DaggerAppCompon.builder()
            .context(this)
            .build()
            .inject(this)*/
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Log.println(priority, tag, message)
        }
    }
}
