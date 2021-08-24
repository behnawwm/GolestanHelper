package ir.behnawwm.golestanhelper.views.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.behnawwm.golestanhelper.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    lateinit var binding : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}