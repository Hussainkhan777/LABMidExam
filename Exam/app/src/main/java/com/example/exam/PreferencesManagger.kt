package com.example.exam

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

public class PreferencesManager(context: Context) {
    private val preferences = context.getSharedPreferences("class_practice", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return preferences.getString(key, null) ?: defaultValue
    }
}

@Composable
fun MyComposabIeFunction() {
    val context = LocalContext.current
    val preferencesManager = remember {
        PreferencesManager(context)
    }
    val data = remember { mutableStateOf(preferencesManager.getData("myKey", "")) }

    preferencesManager.saveData("myKey", data.value)
}
