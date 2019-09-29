package com.example.mockcurious

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MainModule::class,
    NetworkModule::class
])
interface AppComponent {
    fun inject(app: App)
}
