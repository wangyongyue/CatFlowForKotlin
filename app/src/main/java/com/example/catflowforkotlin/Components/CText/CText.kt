package com.example.wangyongyue.myapplication.Components.CText

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import com.example.wangyongyue.myapplication.Observe.Observe

class CText:TextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)



    //{{ msg }}
    fun v_text(ob: Observe){

        ob.setupObserve {

            this.setText(ob.v_text)
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


}