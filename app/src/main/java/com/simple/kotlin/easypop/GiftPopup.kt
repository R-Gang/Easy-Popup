package com.simple.kotlin.easypop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gang.kotlin.popup.BasePopup
import com.gang.recycler.kotlin.manager.LayoutManager
import com.gang.tools.kotlin.dimension.dip2px
import com.simple.kotlin.R

/**
 * Created by haoruigang on 2017/8/7.
 */
class GiftPopup(context: Context?) : BasePopup<GiftPopup?>() {
    private var mRecyclerView: RecyclerView? = null
    override fun initAttributes() {
        setContentView(R.layout.layout_gift)
        setHeight(dip2px(200f).toInt())
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
        setFocusAndOutsideEnable(true)
    }

    override fun initViews(view: View?, basePopup: GiftPopup?) {
        mRecyclerView = findViewById(R.id.rv_gift)
        mRecyclerView?.apply {
            LayoutManager.instance?.initRecyclerGrid(this, 4)
            val list = createList()
            val adapter = GiftAdapter(context, list as MutableList<String>)
            mRecyclerView?.adapter = adapter
        }
    }

    private fun createList(): List<String> {
        val list: MutableList<String> = ArrayList(1)
        for (i in 0..14) {
            list.add("")
        }
        return list
    }

    companion object {
        fun create(context: Context?): GiftPopup {
            return GiftPopup(context)
        }
    }

    init {
        setContext(context)
    }
}