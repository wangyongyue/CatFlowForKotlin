package com.example.wangyongyue.myapplication.Components.CView

import android.content.Context
import android.graphics.Color
import android.opengl.Visibility
import android.util.AttributeSet
import android.view.View
import com.example.wangyongyue.myapplication.Observe.Observe
import java.util.*

class CView:View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)

//    v-bind
    fun v_bind(ob:Observe){
        ob.setupObserve {

        }

    }
//    v-if
    fun v_if(ob:Observe){
        ob.setupObserve {

            if (ob.v_if != null){

                this.visibility = ob.v_if!!

            }

        }


    }



}