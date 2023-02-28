package com.haznedar.newsapp.common

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

suspend fun internetCheck(): Boolean = withContext(Dispatchers.Main) {

    val runTime = Runtime.getRuntime()

    try {

        val ipProcess = runTime.exec("/system/bin/ping -c 1 www.google.com")
        val exitValue: Int = ipProcess.waitFor()
        return@withContext (exitValue == 0)

    } catch (e: IOException) {

        e.printStackTrace()

    } catch (e: InterruptedException) {

        e.printStackTrace()
    }

    return@withContext false
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun String.ValueChecker(): Boolean {

    return this.trim().isNotEmpty() && this != "NULL" && this != "null" && this != "Null"

}

fun EditText.ValueChecker(): Boolean {

    return this.text.toString().trim()
        .isNotEmpty() && this.text.toString() != "NULL" && this.text.toString() != "null" && this.text.toString() != "Null"

}

fun String.ValueChanger(): String {

    return this.toString().trim()

}

fun EditText.ValueChanger(): String {

    return this.text.toString().trim()
}