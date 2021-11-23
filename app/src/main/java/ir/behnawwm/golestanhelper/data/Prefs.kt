package ir.behnawwm.golestanhelper.data

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val APP_PREF_BOOLEAN_FIRST_TIME = "booleanFirstTime"
    private val APP_PREF_INTEGER_PEOPLE_TYPE = "intPeopleType"

    private val preferences: SharedPreferences =
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    var booleanIsFirstTime: Boolean
        get() = preferences.getBoolean(APP_PREF_BOOLEAN_FIRST_TIME, true)
        set(value) = preferences.edit().putBoolean(APP_PREF_BOOLEAN_FIRST_TIME, value).apply()

    var intPeopleType: Int
        get() = preferences.getInt(APP_PREF_INTEGER_PEOPLE_TYPE, 0)
        set(value) = preferences.edit().putInt(APP_PREF_INTEGER_PEOPLE_TYPE, value).apply()
}