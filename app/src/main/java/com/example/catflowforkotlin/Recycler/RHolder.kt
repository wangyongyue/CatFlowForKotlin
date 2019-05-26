package com.example.wangyongyue.myapplication.Recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wangyongyue.myapplication.Components.Cat

open abstract class RHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){

    open fun setData(item: Cat){}

}

