package com.android.localapi.Utilities

import com.android.localapi.Model.ModelProduct
import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface ApiInterface {
    @GET("test")
    fun getProduct() : Call<ArrayList<ModelProduct>>
}