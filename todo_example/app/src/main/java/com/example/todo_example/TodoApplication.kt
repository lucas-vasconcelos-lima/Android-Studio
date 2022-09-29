package com.example.todo_example

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// indica que o aplicativo como um t.odo pode utilizar o hilt
@HiltAndroidApp
class TodoApplication : Application() {
}