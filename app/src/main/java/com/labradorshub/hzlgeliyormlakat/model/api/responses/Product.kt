package com.labradorshub.hzlgeliyormlakat.model.api.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("price")
    var price:Float,
    @SerializedName("description")
    var description:String,
    @SerializedName("category")
    var category:String,
    @SerializedName("image")
    var image:String
) : Parcelable
