package com.example.mockcurious.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val annotation = javaClass.getAnnotation(ContentView::class.java)
        if (annotation != null) {
            val layoutId = annotation.value
            if (layoutId != 0) {
                return inflater.inflate(layoutId, container, false)
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}