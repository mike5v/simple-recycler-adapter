package it.mike5v.example

import android.app.Application
import android.util.Log

/**
 * Created by Michele Quintavalle
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("APP", "App initialized")
    }
}
