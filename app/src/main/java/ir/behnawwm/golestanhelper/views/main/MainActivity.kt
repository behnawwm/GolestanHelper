package ir.behnawwm.golestanhelper.views.main

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.edit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import ir.behnawwm.golestanhelper.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*
import nl.joery.animatedbottombar.AnimatedBottomBar


var animationPlaybackSpeed: Double = 0.8

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var mainListAdapter: MainListAdapter
    lateinit var navController: NavController
    private var pressedTime: Long = 0


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


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.topAppBar)

        //todo commented test
        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newIndex) {
                    0 -> {
                        navController.navigate(R.id.action_global_searchFragment)
                        binding.topAppBar.title = "جستجو سریع"
                    }
                    1 -> {
                        if (newIndex > lastIndex) {
                            navController.navigate(R.id.action_global_gudieFragment_from_left)
                        } else {
                            navController.navigate(R.id.action_global_gudieFragment_from_right)
                        }
                        binding.topAppBar.title = "راهنمای آموزشی"
                    }
                    2 -> {
                        navController.navigate(R.id.action_global_categoryFragment)
                        binding.topAppBar.title = "دسته بندی های جامع"
                    }

                    else -> {
                    }
                }.also {
                    hideKeyboard()
                }
            }
        })

//            // An optional method that will be fired whenever an already selected tab has been selected again.
//            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
//                Log.d("bottom_bar", "Reselected index: $index, title: ${tab.title}")
//            }


//        if (isFirstTime) {
//            isFirstTime = false
//        }
    }

    /**
     * Called from FiltersLayout to get adapter scale down animator
     */
    fun getAdapterScaleDownAnimator(isScaledDown: Boolean): ValueAnimator =
        mainListAdapter.getScaleDownAnimator(isScaledDown)


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.menu_aboutus -> {
                if (navController.currentDestination?.label != "AboutUsFragment")    //todo change this to a better way!
                    navController.navigate(R.id.action_global_aboutUsFragment)
            }
            R.id.menu_saved -> {
                if (navController.currentDestination?.label != "SavedFragment")     //todo change this to a better way!
                    navController.navigate(R.id.action_global_savedFragment)
            }
            R.id.menu_faq -> {
                if (navController.currentDestination?.label != "FaqFragment")     //todo change this to a better way!
                    navController.navigate(R.id.action_global_faqFragment)
            }
            R.id.menu_person -> Toast.makeText(
                applicationContext,
                "Not implemented yet!",
                Toast.LENGTH_SHORT
            ).show()  //todo
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

//    override fun onBackPressed() {
//        if (pressedTime + 2000 > System.currentTimeMillis()) {
//            super.onBackPressed();
//            finish();
//        } else {
//            Snackbar.make(binding.root, "Press back again to exit", Snackbar.LENGTH_SHORT)
//                .setBackgroundTint(resources.getColor(R.color.black_normal))
//                .setTextColor(resources.getColor(R.color.white))
//                .show()
//        }
//        pressedTime = System.currentTimeMillis();
//    }
}