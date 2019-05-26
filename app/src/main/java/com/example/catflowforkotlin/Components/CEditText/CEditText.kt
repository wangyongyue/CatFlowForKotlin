package com.example.wangyongyue.myapplication.Components.CEditText

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import com.example.wangyongyue.myapplication.Observe.Observe
import com.example.wangyongyue.myapplication.Observe.observeBlock

typealias changeBlock = (String) -> Unit
class CEditText:EditText,TextWatcher{
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
    //v-input
    var ob:Observe? = null
    fun v_input(ob: Observe){

        this.addTextChangedListener(this)

        this.ob = ob

    }

    //v-change
    var v_change:changeBlock? = null
    fun v_change(ob: changeBlock){

        this.addTextChangedListener(this)
        this.v_change = ob

    }
    override fun afterTextChanged(s: Editable?) {


    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }


    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)


        this.ob?.v_text {
            return@v_text text.toString()
        }


        this.v_change?.invoke(text.toString())

    }



}