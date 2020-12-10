package com.labradorshub.hzlgeliyormlakat.ui.login

import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseViewModel

class LoginViewModel : BaseViewModel() {

    var mail: MutableLiveData<String> = MutableLiveData()
    var pass: MutableLiveData<String> = MutableLiveData()
    var login :MutableLiveData<Boolean> = MutableLiveData()
    var forgotpass:MutableLiveData<Boolean> = MutableLiveData()
    var newacc:MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        login.value=false
        forgotpass.value=false
        newacc.value=false
    }

    fun login(v: View){
        if(mail.value?.length!!<8 && !Patterns.EMAIL_ADDRESS.matcher(mail.value).matches()){
            Toast.makeText(v.context,"Mailiniz hatali!",Toast.LENGTH_SHORT).show()
        }
        if(pass.value?.length!!<8){
            Toast.makeText(v.context,"Sifreniz hatali",Toast.LENGTH_SHORT).show()
        }else{
            if(mail.value.equals("demo@hizligeliyo.com") && pass.value.equals("123456789")){
                login.value=true
            }else{
                Toast.makeText(v.context,"Giris hatali",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun forgotpass(){
        forgotpass.value=true
    }

    fun newacc(){
        newacc.value=true
    }
}