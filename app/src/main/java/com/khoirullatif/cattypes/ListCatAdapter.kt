package com.khoirullatif.cattypes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListCatAdapter(private val listCat: ArrayList<Cat>): RecyclerView.Adapter<ListCatAdapter.ListViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemCallback(callback: OnItemClickCallback){
//        this.onItemClickCallback = callback
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_cat, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cat = listCat[position]

        Glide.with(holder.itemView.context)
            .load(cat.image)
            .apply(RequestOptions().override(60, 60))
            .into(holder.imgImage)

        holder.tvType.text = cat.type
        holder.tvDetail.text = cat.detail

//        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listCat[holder.adapterPosition])}
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, CatDetailActivity::class.java)// bisa pakai contex aja tanpa it. asalkan variable context di definisikan di constructor di atas
            intent.putExtra("TYPE_CAT", cat.type)
            intent.putExtra("DETAIL_CAT", cat.detail)
            intent.putExtra("IMAGE_CAT", cat.image)
            intent.putExtra("PRICE_CAT", cat.price)
            it.context.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvType: TextView = itemView.findViewById(R.id.tv_cat_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail)
        var imgImage: ImageView = itemView.findViewById(R.id.img_item_cat)
//        var rvRowItem: RelativeLayout = itemView.findViewById(R.id.rv_row_item)
    }

//    interface OnItemClickCallback {
//        fun onItemClicked(data: Cat)
//    }
}