package dev.ilhamsuaib.app

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

inline fun <reified T> T.logD(s: String) {
    val tag = T::class.java.simpleName
    Log.d(tag, s)
}

val Any.toJson: JsonElement
    get() = Gson().toJsonTree(this)