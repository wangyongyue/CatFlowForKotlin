package com.example.wangyongyue.myapplication.Components.CImageButton

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageButton
import com.example.wangyongyue.myapplication.Observe.Observe
import com.example.wangyongyue.myapplication.Observe.observeBlock

class CImageButton:ImageButton{

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)

    //v-image
    fun v_image(ob: Observe){

        ob.setupObserve {

            this.setImageBitmap(ob.v_image)
        }

    }
    //v-bind
    fun v_bind(ob: Observe){
        ob.setupObserve {

            this.setBackgroundColor(Color.red(1))
        }

    }
    //v-if
    fun v_if(ob: Observe){

        ob.setupObserve {

            this.visibility = ob.v_if!!
        }

    }
    //v-on
    fun v_on(ob: Observe){

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