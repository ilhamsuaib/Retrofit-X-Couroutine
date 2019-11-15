package dev.ilhamsuaib.app.data

import android.content.Context

/**
 * Created by @ilhamsuaib on 2019-11-03.
 * github.com/ilhamsuaib
 */

class Preferences(context: Context) {

    private val sp by lazy { context.getSharedPreferences("my_pref", Context.MODE_PRIVATE) }
    private val spe by lazy { sp.edit() }

    fun putString(key: String, value: String) {
        spe.putString(key, value)
        spe.commit()
    }

    fun getString(key: String): String? = sp.getString(key, null)
}