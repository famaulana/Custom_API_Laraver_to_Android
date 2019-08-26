package com.android.localapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.localapi.Model.ModelProduct
import com.android.localapi.R

class ProductAdapter(val context : Context, val products : ArrayList<ModelProduct>):RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_data, null)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products.get(position)
        holder.idProduct.text = product.id.toString()
        holder.namaProduct.text = product.nama
        holder.merekProduct.text = product.merek
    }

    class ProductHolder(view: View):RecyclerView.ViewHolder(view){
        val idProduct: TextView
        val namaProduct: TextView
        val merekProduct: TextView
        init {
            idProduct = view.findViewById(R.id.idProduct)
            namaProduct = view.findViewById(R.id.namaProduct)
            merekProduct = view.findViewById(R.id.merekProduct)
        }
    }
}