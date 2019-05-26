package com.example.wangyongyue.myapplication.Router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.example.wangyongyue.myapplication.CActivity.CActivity
import java.util.*





typealias popCallBack = (obj:Any) -> Unit

class Router {

    private val activityStack: Stack<Activity> = Stack()
    var block:popCallBack? = null

    companion object {

        val instance: Router by lazy { Router() }

        fun <T> push(clazz: Class<T>){

            val topAc = instance.topActivity()
            val intent = Intent()
            intent.setClass(topAc,clazz)
            topAc.startActivity(intent)
        }
        fun <T> push(clazz: Class<T>,className:String){

            val topAc = instance.topActivity()
            val intent = Intent()
            intent.setClass(topAc,clazz)
            val name = className.split('$')[0]
            intent.putExtra("className",name)
            topAc.startActivity(intent)
        }
        fun pop(){

            val topAc = instance.topActivity()
            topAc.finish()
        }
        fun <T> push(clazz:Class<T>,className:String,data:String){

            val topAc = instance.topActivity() as CActivity
            val intent = Intent()
            intent.putExtra("data",data)
            val name = className.split('$')[0]
            intent.putExtra("className",name)
            intent.setClass(topAc,clazz)
            topAc.startActivity(intent)


        }
        fun <T> push(clazz:Class<T>,className:String,data:String,block: popCallBack){

            val topAc = instance.topActivity() as CActivity
            val intent = Intent()
            instance.block = block
            intent.putExtra("data",data)
            val name = className.split('$')[0]
            intent.putExtra("className",name)
            intent.setClass(topAc,clazz)
            topAc.startActivity(intent)


        }
        fun pop(data:Any){

            val topAc = instance.topActivity() as CActivity
            instance.block?.invoke(data)
            topAc.finish()
            instance.block = null

        }



    }


    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }
    fun removeActivity(activity: Activity) {
        if (activityStack.contains(activity)) {
            activity.finish()
            activityStack.remove(activity)
        }
    }
    fun topActivity(): Activity {
        return activityStack.lastElement()
    }
    fun clearActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }
    fun exitApp(context: Context) {
        clearActivity()
//        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }






}