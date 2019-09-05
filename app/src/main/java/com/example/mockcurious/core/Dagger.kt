package com.example.mockcurious.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import kotlin.reflect.KClass

@Module
interface DaggerArchComponentModule {
    @Binds
    fun bindViewModelFactory(factory: DaggerInjectionFactory): ViewModelProvider.Factory
}

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(
    val value: KClass<out ViewModel>
)

