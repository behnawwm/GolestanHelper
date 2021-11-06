package ir.behnawwm.golestanhelper.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.views.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.animation.Animator
import android.animation.ArgbEvaluator
import java.lang.Exception
import android.animation.ObjectAnimator
import android.graphics.Color
import ir.behnawwm.golestanhelper.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.tvGolestan1.startAnimation(AlphaAnimation(0F, 1F).apply {
//            duration = 1000
//            fillAfter = true
//        })

//        binding.tvGolestan2.startAnimation(AlphaAnimation(0F, 1F).apply {
//            duration = 1000
//            fillAfter = true
//        })
        playTextAnimation()

        binding.animationview.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(baseContext, MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })

    }

    private fun playTextAnimation() {
        val colorAnim: ObjectAnimator = ObjectAnimator.ofInt(
            binding.tvGolestan1, "textColor",
            Color.WHITE, resources.getColor(R.color.blue_f)
        )
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.duration = 2000
        colorAnim.start()


        val colorAnim2: ObjectAnimator = ObjectAnimator.ofInt(
            binding.tvGolestan2, "textColor",
            Color.WHITE, resources.getColor(R.color.blue_f)
        )
        colorAnim2.setEvaluator(ArgbEvaluator())
        colorAnim2.duration = 2000
        colorAnim2.start()
    }
}