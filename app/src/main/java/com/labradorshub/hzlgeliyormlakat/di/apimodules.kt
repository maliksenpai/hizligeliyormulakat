package com.labradorshub.hzlgeliyormlakat.di

import com.labradorshub.hzlgeliyormlakat.model.api.Api
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public val apimodule = module {
    single { createnetwork("https://fakestoreapi.com/") }
    factory { apirepository(get()) }
}

fun createnetwork(url:String) : Api.ApiInterface = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient())
    .build()
    .create(Api.ApiInterface::class.java)

class apirepository(private val api:Api.ApiInterface){
    fun getproducts() = api.getproducts()
}