package kotlinclass.leminh.kotlin_week2.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinclass.leminh.kotlin_week2.LoginActivity
import kotlinclass.leminh.kotlin_week2.R
import kotlinclass.leminh.kotlin_week2.databinding.ActivitySignupBinding
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity: AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewmodel: SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setUp()
        binding.apply {
            btnSignin.setOnClickListener{
                goToSignIn()
            }
//            invalidateAll()
        }
        viewmodel.isSuccess.observe(this , Observer {
            Log.d("TAG","go to signup isSuccess viewmodel")
            it?.let{
                if(it){
                    Log.d("TAG","go to signup viewmodel $it")
                    Toast.makeText(this,"Signup successful!",Toast.LENGTH_LONG).show()
                    goToSignIn()
                }
            }
        })
        viewmodel.isError.observe(this, Observer { message ->
            Log.d("TAG","go to signup isError viewmodel: $message")
            message?.let{
                Toast.makeText(this,message,Toast.LENGTH_LONG).show()
            }

        })
    }
    fun setUp(){
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        viewmodel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.lifecycleOwner = this
        binding.signupViewModel = viewmodel
    }
    fun goToSignIn(){
        intent = Intent(this@SignupActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStop() {
        super.onStop()
        viewmodel.clear()
    }
}