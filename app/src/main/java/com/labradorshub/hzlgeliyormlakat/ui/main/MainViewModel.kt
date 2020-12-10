package com.labradorshub.hzlgeliyormlakat.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.labradorshub.hzlgeliyormlakat.di.apirepository
import com.labradorshub.hzlgeliyormlakat.model.api.responses.Product
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val apirepository: apirepository) : BaseViewModel() {

    var products = MutableLiveData<List<Product>?>()
    var filter = MutableLiveData<Boolean>()
    var filtername = MutableLiveData<String>()
    var mutablelist = listOf<Product>()
    var text = MutableLiveData<String>()

    fun init(){
        text.value=""
        apirepository.getproducts().enqueue(object : Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("gelenhata",t.message.toString()+" ")
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.code()==200){
                    mutablelist = response.body()!!
                    filtername.value="hepsi"
                    if(filtername.value.equals("hepsi")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.title.contains(text.value!!)){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("men clothing")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("men clothing")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("women clothing")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("women clothing")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("jewelery")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("jewelery")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("electronics")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("electronics")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }
                }
            }

        })
    }

    fun filtered(){
        apirepository.getproducts().enqueue(object : Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("gelenhata",t.message.toString()+" ")
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.code()==200){
                    mutablelist = response.body()!!
                    if(filtername.value.equals("hepsi")){
                        products.value=mutablelist
                    }else if(filtername.value.equals("men clothing")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("men clothing")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("women clothing")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("women clothing")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("jewelery")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("jewelery")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }else if(filtername.value.equals("electronics")){
                        var temp = mutableListOf<Product>()
                        for(product in mutablelist){
                            if(product.category.equals("electronics")){
                                temp.add(product)
                            }
                        }
                        products.value=temp
                    }
                    searched(text.value!!)
                }
            }

        })
    }

    fun searched(searchedtext:String) : MutableList<Product>?{
        Log.d("gelen","asd"+searchedtext)
        var list = mutableListOf<Product>()
        if(!products.value.isNullOrEmpty()){
            for(product in products.value!!){
                if(product.title.toLowerCase().contains(searchedtext)){
                    list.add(product)
                }
            }
        }
        return list
    }

    fun openfilter(){
        filter.value=true
    }

    fun closefilter(){
        filtername.value="hepsi"
        filter.value=false
        filtered()
    }

    fun men(){
        filtername.value="men clothing"
        filter.value=false
        filtered()
    }

    fun women(){
        filtername.value="women clothing"
        filter.value=false
        filtered()
    }

    fun electronics(){
        filtername.value="electronics"
        filter.value=false
        filtered()
    }

    fun jewelery(){
        filtername.value="jewelery"
        filter.value=false
        filtered()
    }
}