package com.android.localapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.localapi.Adapter.ProductAdapter
import com.android.localapi.Model.ModelProduct
import com.android.localapi.Utilities.ApiClient
import com.android.localapi.Utilities.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcView.layoutManager = LinearLayoutManager(this)
        btnRefresh.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        val apiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        apiInterface.getProduct().enqueue(object : Callback<ArrayList<ModelProduct>>{
            override fun onFailure(call: Call<ArrayList<ModelProduct>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error Connection", Toast.LENGTH_SHORT).show()
                e("Error", t!!.message, t)
            }

            override fun onResponse(call: Call<ArrayList<ModelProduct>>?, response: Response<ArrayList<ModelProduct>>?) {
                if (response!!.code() == 200){
                    rcView.adapter = ProductAdapter(this@MainActivity, response.body())
                }else{
                    Toast.makeText(this@MainActivity, "Error Server", Toast.LENGTH_SHORT).show()
                    e("Error", "Error Server")
                }
            }


        })
    }
}
