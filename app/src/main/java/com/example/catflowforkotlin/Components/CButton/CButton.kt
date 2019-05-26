package com.example.wangyongyue.myapplication.Components.CButton

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import com.example.wangyongyue.myapplication.Observe.Observe
import com.example.wangyongyue.myapplication.Observe.observeBlock

class CButton:Button {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)

    //{{ msg }}
    fun v_text(ob:Observe){

        ob.setupObserve {
            this.setText(ob.v_text)
        }

    }
    //v-image
    fun v_image(ob:Observe){

        ob.setupObserve {

        }

    }
    //v-bind
    fun v_bind(ob:Observe){
        ob.setupObserve {

            this.setBackgroundColor(Color.red(1))
        }

    }
    //v-if
    fun v_if(ob:Observe){

        ob.setupObserve {

            this.visibility = ob.v_if!!
        }

    }
    //v-on
    var ob:Observe? = null
    fun v_on(ob:Observe){

        this.ob = ob
        this.setOnClickListener {

            ob.v_on?.invoke()

        }

    }

    //v-click
    fun v_click(ob:observeBlock){

        this.setOnClickListener {

            ob()
        }

    }

}