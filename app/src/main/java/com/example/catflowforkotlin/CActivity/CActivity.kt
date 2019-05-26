package com.example.wangyongyue.myapplication.CActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wangyongyue.myapplication.Router.Router
import kotlinx.android.synthetic.main.activity_main.*

open class CActivity: AppCompatActivity() {

    val params:String
        get() {return this.intent.getStringExtra("data")}
    val className:String
        get() {return this.intent.getStringExtra("className")}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Router.instance.addActivity(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        Router.instance.removeActivity(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }

}