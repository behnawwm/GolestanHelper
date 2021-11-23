package ir.behnawwm.golestanhelper.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.security.identity.ResultData
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.CachingRepo
import ir.behnawwm.golestanhelper.data.api.ApiService
import ir.behnawwm.golestanhelper.data.database.dao.RequestDao
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.databinding.ActivityRoleSelectBinding
import ir.behnawwm.golestanhelper.prefs
import ir.behnawwm.golestanhelper.views.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RoleSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoleSelectBinding

    @Inject
    lateinit var cachingRepo: CachingRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonGroupView()

        binding.apply {
            binding.btnNext.setOnClickListener {
                when (binding.radioGroup.checkedRadioButtonId) {
                    R.id.radiobutton_karshenasi -> prefs.intPeopleType = 98
                    R.id.radiobutton_arshad -> prefs.intPeopleType = 98
                    R.id.radiobutton_ostad -> prefs.intPeopleType = 300
                }
                navigateToNextActivity()
            }
        }
    }

    private fun initButtonGroupView() {
        when (prefs.intPeopleType) {
            1 -> binding.radiobuttonKarshenasi.isChecked = true
            2 -> binding.radiobuttonArshad.isChecked = true
            3 -> binding.radiobuttonOstad.isChecked = true
        }
    }

    private fun navigateToNextActivity() {
        if (prefs.intPeopleType != 0)
            populateDatabase()
        else
            Toasty.warning(baseContext, "یکی از گزینه ها را انتخاب کنید!", Toast.LENGTH_SHORT, true)
                .show()
    }

    private fun populateDatabase() {
        val loadingDialog = MaterialAlertDialogBuilder(this)
            .setView(R.layout.dialog_loading)
            .setCancelable(false)
            .show()

        lifecycleScope.launch {
            try {
                cachingRepo.loadDbFromApi()
                loadingDialog.dismiss()
                prefs.booleanIsFirstTime = false
                startActivity(Intent(baseContext, MainActivity::class.java))
                finish()
            } catch (t: Throwable) {
                Toasty.error(baseContext, t.message.toString(), Toast.LENGTH_SHORT, true)
                    .show()
                loadingDialog.dismiss()
            }

        }
    }
}

