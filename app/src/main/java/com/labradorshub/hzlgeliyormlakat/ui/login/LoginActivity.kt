package com.labradorshub.hzlgeliyormlakat.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.labradorshub.hzlgeliyormlakat.R
import com.labradorshub.hzlgeliyormlakat.databinding.ActivityLoginBinding
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseActivity
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseViewModel
import com.labradorshub.hzlgeliyormlakat.ui.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>(LoginViewModel::class.java){

    val loginViewModel : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun init() {

    }

    override fun initviewmodel() {
        binding.viewModel = loginViewModel
        loginViewModel.init()
        loginViewModel.login.observe(this, Observer {
            if(it==true){
                startActivity(Intent(this,MainActivity::class.java))
            }
        })
        loginViewModel.forgotpass.observe(this, Observer {
            if(it==true){
                //şifremi unuttum sayfasına gider
                Log.d("gelen","forgotpass")
            }
        })
        loginViewModel.newacc.observe(this, Observer {
            if(it==true){
                //kayıt ol sayfasına gider
                Log.d("gelen","newacc")
            }
        })
    }

}