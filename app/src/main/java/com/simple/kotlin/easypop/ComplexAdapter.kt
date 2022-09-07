package com.simple.kotlin.easypop

import android.content.Context
import android.widget.TextView
import com.gang.recycler.kotlin.interfaces.ViewOnItemClick
import com.gang.recycler.kotlin.recycleradapter.RecyclerAdapter
import com.gang.recycler.kotlin.recycleradapter.RecyclerViewHolder
import com.simple.kotlin.R


class ComplexAdapter(`object`: Any, datas: MutableList<*>, onItemClick1: ViewOnItemClick) :
    RecyclerAdapter(datas, `object`, onItemClick1) {

    override val layoutResId: Int
        get() = R.layout.item_complex

    override fun convert(holder: RecyclerViewHolder, position: Int, context: Context) {
        holder.getView2<TextView>(R.id.tv_complex_item).text = datas[position].toString()
    }
}