package com.example.wangyongyue.myapplication.Observe

import android.content.Context
import android.graphics.Bitmap
import android.media.Image
import android.util.Log.v
import android.view.View
import com.example.wangyongyue.myapplication.Components.Cat

typealias observeBlock = () -> Unit
typealias observeIndexBlock = (Int) -> Unit
typealias observeEventBlock = (Cat) -> Unit

class Observe{


    val list = mutableListOf<observeBlock>()

    var v_text:String? = null
    fun v_text(v:()->String?){

        v_text = v()
        sendObserveMsg()
    }

    var v_image:Bitmap? = null
    fun v_image(v:()->Bitmap?){

        v_image = v()
        sendObserveMsg()
    }

    var v_blind:Map<String ,String>? = null
    fun v_blind(v:()->Map<String ,String>?){

        v_blind = v()
        sendObserveMsg()
    }

    var v_if:Int?= null
    fun v_if(v:()->Int?){

        v_if = v()
        sendObserveMsg()
    }

    var v_on:observeBlock? = null
    fun v_on(ob:observeBlock){

        v_on = ob

    }

    var v_index:observeIndexBlock? = null
    fun v_index(ob:observeIndexBlock){

        v_index = ob

    }

    var v_event:observeEventBlock? = null
    fun v_event(ob:observeEventBlock){

        v_event = ob

    }

    var v_list:MutableList<Cat>? = null
    fun v_list(isPage:Boolean,v:() -> MutableList<Cat>){
        if (isPage){

            if (v_list == null){

                v_list = v()

            }else{

                v_list?.addAll(v())
            }

        }else{

            v_list = v()

        }
        sendObserveMsg()
    }

    fun setupObserve(callBack:observeBlock){

        list.add(callBack)

    }
    fun sendObserveMsg(){

        for (value in list){

            value.invoke()
        }
    }



}