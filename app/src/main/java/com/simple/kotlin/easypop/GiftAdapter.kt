package com.simple.kotlin.easypop

import android.content.Context
import com.gang.recycler.kotlin.recycleradapter.RecyclerAdapter
import com.gang.recycler.kotlin.recycleradapter.RecyclerViewHolder
import com.simple.kotlin.R

/**
 * Created by haoruigang on 2017/8/7.
 */
class GiftAdapter(`object`: Any, datas: MutableList<String>) : RecyclerAdapter(datas, `object`) {

    override val layoutResId: Int
        get() = R.layout.layout_item_gift

    override fun convert(holder: RecyclerViewHolder, position: Int, context: Context) {
    }
}