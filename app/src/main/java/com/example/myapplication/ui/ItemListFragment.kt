package com.example.myapplication.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.entity.Item
import com.example.myapplication.network.NetworkProvider
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_list_view.*

class ItemListFragment:Fragment() {
    private lateinit var itemRecyclerView:RecyclerView
    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var items:ArrayList<Item>
    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var np: NetworkProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        np = NetworkProvider(object :
            NetworkProvider.NetworkProviderListener {
            override fun getAllSuccess(_items: ArrayList<Item>) {
                items.clear()
                for (i in _items) {
                    items.add(i)
                }
                itemListAdapter.notifyDataSetChanged()
            }

            override fun getAllFail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        items = ArrayList()
        for(i in 1..10) {
            items.add(Item("title $i"))
        }
        itemListAdapter = ItemListAdapter(items)
        linearLayoutManager = LinearLayoutManager(context)
        itemRecyclerView = itemListRecyclerView.apply {
            adapter = itemListAdapter
            layoutManager = linearLayoutManager
            setHasFixedSize(false)
        }
        np.getAll()
        super.onViewCreated(view, savedInstanceState)
    }

}