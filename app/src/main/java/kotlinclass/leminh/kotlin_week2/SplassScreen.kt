package kotlinclass.leminh.kotlin_week2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinclass.leminh.kotlin_week2.OnBoarding.OnBoardingActivity
import kotlinclass.leminh.kotlin_week2.signup.SignupActivity

@Suppress("DEPRECATION")
class SplassScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splass_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            var intent = Intent(this@SplassScreen, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}