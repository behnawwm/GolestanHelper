package ir.behnawwm.golestanhelper.data

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val APP_PREF_BOOLEAN_FIRST_TIME = "booleanFirstTime"

    private val preferences: SharedPreferences =
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    var booleanIsLoggedIn: Boolean
        get() = preferences.getBoolean(APP_PREF_BOOLEAN_FIRST_TIME, true)
        set(value) = preferences.edit().putBoolean(APP_PREF_BOOLEAN_FIRST_TIME, value).apply()

}