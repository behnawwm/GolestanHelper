package ir.behnawwm.golestanhelper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ir.behnawwm.golestanhelper.data.Prefs
import okhttp3.internal.Internal.instance


val prefs: Prefs by lazy {
    MyApp.prefs!!
}

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        var prefs: Prefs? = null
        lateinit var instance: MyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefs = Prefs(applicationContext)
    }

}