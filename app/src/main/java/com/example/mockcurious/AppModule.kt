package com.example.mockcurious

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(@get:Provides val app: Context)