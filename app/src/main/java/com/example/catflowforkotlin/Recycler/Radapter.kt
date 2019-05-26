package com.example.wangyongyue.myapplication.Recycler

import android.content.Context
import android.content.pm.ActivityInfo
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.wangyongyue.myapplication.Components.Cat
import android.view.LayoutInflater
import android.widget.Toast
import com.example.wangyongyue.myapplication.Observe.Observe
import kotlin.reflect.KClass

typealias IndexBlock = (Int) -> Unit

class Radapter(var mapHolder : Map<Int,String>) : RecyclerView.Adapter<RHolder>() {

    var items = emptyList<Cat>()
    var indexBlock:IndexBlock? = null
    private var obIndex:Observe? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RHolder {

        val holderClass = mapHolder[viewType]
        val view: View = LayoutInflater.from(parent?.context).inflate(viewType, parent, false)
        val holder = Class.forName(holderClass).getConstructor(View::class.java).newInstance(view) as RHolder

        return holder

    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val item = items[position]

        return item.layoutIdentity
    }

    override fun onBindViewHolder(holder: RHolder, position: Int) {
        holder.setData(items[position])
        holder.itemView.setOnClickListener {

            indexBlock?.invoke(position)
            obIndex?.v_index?.invoke(position)
        }
    }

    fun v_didSelect(ob:IndexBlock){

        indexBlock = ob
    }

    fun v_index(ob:Observe){

        obIndex = ob
    }

    //v-list
    fun v_list(ob: Observe){

        ob.setupObserve {

            this.items = ob.v_list!!
            this.notifyDataSetChanged()
        }

    }


}


