package ir.behnawwm.golestanhelper.views.main

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.edit
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import ir.behnawwm.golestanhelper.databinding.ActivityMainBinding


var animationPlaybackSpeed: Double = 0.8

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var mainListAdapter: MainListAdapter

    lateinit var recyclerView: RecyclerView
    lateinit var appbar: AppBarLayout
    lateinit var drawerIcon: View
    lateinit var drawerLayout: DrawerLayout

//    private val loadingDuration: Long
//        get() = (resources.getInteger(R.integer.loadingAnimDuration) / animationPlaybackSpeed).toLong()
    private var pressedTime: Long = 0

    /**
     * Used to open nav drawer when opening app for first time (to show options)
     */
    private val prefs: SharedPreferences
        get() = getSharedPreferences("FabFilter", Context.MODE_PRIVATE)
    private var isFirstTime: Boolean
        get() = prefs.getBoolean("isFirstTime", true)
        set(value) = prefs.edit { putBoolean("isFirstTime", value) }

    /**
     * Used by FiltersLayout since we don't want to expose mainListAdapter (why?)
     * (Option: Combine everything into one activity if & when necessary)
     */
    var isAdapterFiltered: Boolean
        get() = mainListAdapter.isFiltered
        set(value) {
            mainListAdapter.isFiltered = value
        }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init
        recyclerView = binding.recyclerView
        appbar = binding.appbar
        drawerIcon = binding.drawerIcon
        drawerLayout = binding.drawerLayout

        // Appbar behavior init
        (appbar.layoutParams as CoordinatorLayout.LayoutParams).behavior = ToolbarBehavior()

        // RecyclerView Init
        mainListAdapter = MainListAdapter(this)
        recyclerView.adapter = mainListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
//        updateRecyclerViewAnimDuration()

        // Nav Drawer Init
        drawerIcon.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }

        // Open Nav Drawer when opening app for the first time
        if (isFirstTime) {
            drawerLayout.openDrawer(GravityCompat.START)
            isFirstTime = false
        }
    }


//    private fun updateRecyclerViewAnimDuration() = recyclerView.itemAnimator?.run {
//        removeDuration = loadingDuration * 60 / 100
//        addDuration = loadingDuration
//    }

    /**
     * Open browser for given string resId URL
     */
    private fun openBrowser(@StringRes resId: Int): Unit =
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(resId))))

    /**
     * Called from FiltersLayout to get adapter scale down animator
     */
    fun getAdapterScaleDownAnimator(isScaledDown: Boolean): ValueAnimator =
        mainListAdapter.getScaleDownAnimator(isScaledDown)

    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Snackbar.make(binding.root, "Press back again to exit", Snackbar.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis();
    }
}