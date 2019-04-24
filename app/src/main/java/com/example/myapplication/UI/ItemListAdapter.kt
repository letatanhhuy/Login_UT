package com.example.myapplication.UI

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Entity.Item
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_row_view.view.*

class ItemListAdapter(var data:ArrayList<Item>):RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    class ItemViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_row_view, p0, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.view.txtTitle.text = data[p1].title
    }

    override fun getItemCount(): Int {
        return data.size
    }
}