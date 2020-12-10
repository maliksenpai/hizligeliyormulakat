package com.labradorshub.hzlgeliyormlakat.model.api

import com.labradorshub.hzlgeliyormlakat.model.api.responses.Product
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Api() {
    private var retrofit : Retrofit? = null
    private val url = "https://fakestoreapi.com/"

    fun build():Retrofit?{
        if(retrofit==null){
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
            return retrofit
        }
        return retrofit
    }

    interface ApiInterface{
        @GET("products")
        fun getproducts(): Call<List<Product>>
    }
}