package com.simple.kotlin.easypop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.gang.kotlin.popup.BasePopup
import com.gang.recycler.kotlin.interfaces.ViewOnItemClick
import com.gang.recycler.kotlin.manager.LayoutManager
import com.simple.kotlin.R

/**
 * Created by haoruigang on 2017/8/4.
 */
class ComplexPopup(context: Context?) : BasePopup<ComplexPopup?>() {
    private var mOkBtn: Button? = null
    private var mCancelBtn: Button? = null
    private var mRecyclerView: RecyclerView? = null
    private var mComplexAdapter: ComplexAdapter? = null
    override fun initAttributes() {
        setContentView(R.layout.layout_complex,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        setFocusAndOutsideEnable(false)
            ?.setBackgroundDimEnable(true)
            ?.setDimValue(0.5f)
    }

    override fun initViews(view: View?, basePopup: ComplexPopup?) {
        mOkBtn = findViewById(R.id.btn_ok)
        mCancelBtn = findViewById(R.id.btn_cancel)
        mRecyclerView = findViewById(R.id.rv_complex)
        val list: MutableList<String> = ArrayList(1)
        for (i in 0..4) {
            list.add("烤肉盖饭")
        }
        mRecyclerView?.apply {
            LayoutManager.instance?.initRecyclerView(this)
            mComplexAdapter = ComplexAdapter(context, list, object : ViewOnItemClick {
                override fun setOnItemClickListener(view: View?, position: Int) {
                    mComplexAdapter?.notifyItemRemoved(position)
                }
            })
            mRecyclerView?.adapter = mComplexAdapter
        }
        mOkBtn?.setOnClickListener { dismiss() }
        mCancelBtn?.setOnClickListener { dismiss() }
    }

    companion object {
        private const val TAG = "ComplexPopup"
        fun create(context: Context?): ComplexPopup {
            return ComplexPopup(context)
        }
    }

    init {
        setContext(context)
    }
}