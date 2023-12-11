package com.llw.goodstudy

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        instance = this
    }
}