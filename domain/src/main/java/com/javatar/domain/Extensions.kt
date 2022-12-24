package com.javatar.domain

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun String?.value(default: String = ""): String = this ?: default
fun Int?.value(default: Int = 0): Int = this ?: default
fun Double?.value(default: Double = 0.0): Double = this ?: default
fun Date?.value(default: Date = Date()): Date = this ?: default
