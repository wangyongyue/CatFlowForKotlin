package com.example.wangyongyue.myapplication.List

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.wangyongyue.myapplication.Components.Cat
import com.example.wangyongyue.myapplication.Observe.Observe
import com.example.wangyongyue.myapplication.Recycler.IndexBlock

class CAdapter ( var context: Context, var mapHolder : Map<Int,String>) : BaseAdapter() {

    var items = emptyList<Cat>()
    var indexBlock:IndexBlock? = null
    private var obIndex:Observe? = null

    override fun getItem(p0: Int): Any {
        return items.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var view: View
        val item = getItem(position) as Cat
        if (convertView == null) {
            view = View.inflate(context,item.layoutIdentity, null)
            val holderClass = mapHolder[item.layoutIdentity]
            val holder = Class.forName(holderClass).getConstructor(View::class.java).newInstance(view)
            var viewHolder = holder as CHolder
            view.tag = viewHolder
            viewHolder.setData(item)

        } else {

            view = convertView
            val viewHolder = view.tag as CHolder
            viewHolder.setData(item)

        }
        view.setOnClickListener {

            indexBlock?.invoke(position)
            obIndex?.v_index?.invoke(position)
        }


        return view
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