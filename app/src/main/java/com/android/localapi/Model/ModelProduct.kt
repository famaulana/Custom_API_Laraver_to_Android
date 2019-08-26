package com.android.localapi.Model

import com.google.gson.annotations.SerializedName

data class ModelProduct (
    @SerializedName("id") val id : Int,
    @SerializedName("nama") val nama : String,
    @SerializedName("merek") val merek : String
)