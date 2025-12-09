package com.example.modul7

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKampusAdapter(private val listKampus: ArrayList<Kampus>) :
    RecyclerView.Adapter<ListKampusAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kampus, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kampus = listKampus[position]

        holder.imgPhoto.setImageResource(kampus.photo)
        holder.tvName.text = kampus.name
        holder.tvLokasi.text = kampus.lokasi

        holder.itemView.setOnClickListener { view ->
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Detail Kampus: ${kampus.name}")
            builder.setMessage("Lokasi: ${kampus.lokasi}\n\nSejarah: ${kampus.sejarah}")
            builder.setIcon(kampus.photo)
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int = listKampus.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvLokasi: TextView = itemView.findViewById(R.id.tv_item_lokasi)
    }
}