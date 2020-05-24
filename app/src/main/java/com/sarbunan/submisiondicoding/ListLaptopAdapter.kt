package com.sarbunan.submisiondicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListLaptopAdapter(val listLaptop: ArrayList<Laptop>) : RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_laptop, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listLaptop.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, harga, photo, overview, identity) = listLaptop[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = nama
        holder.tvHarga.text = harga

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailLaptop::class.java)
            moveDetail.putExtra(DetailLaptop.EXTRA_NAMA, nama)
            moveDetail.putExtra(DetailLaptop.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailLaptop.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailLaptop.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_nama)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_item_harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}