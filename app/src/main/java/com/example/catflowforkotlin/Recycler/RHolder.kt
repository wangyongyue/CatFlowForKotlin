package com.example.wangyongyue.myapplication.Recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wangyongyue.myapplication.Components.Cat
import com.example.wangyongyue.myapplication.Observe.Observe

open class RHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){

    val v_selectOb = Observe()
    open fun setData(item: Cat){}

}

