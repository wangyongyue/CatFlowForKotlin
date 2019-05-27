package com.example.catflowforkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.wangyongyue.myapplication.CActivity.CActivity
import com.example.wangyongyue.myapplication.Components.Cat
import com.example.wangyongyue.myapplication.Observe.Observe
import com.example.wangyongyue.myapplication.Recycler.RHolder
import com.example.wangyongyue.myapplication.Recycler.Radapter
import com.example.wangyongyue.myapplication.Router.Router
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOb = Observe()

        var holders = mapOf<Int,String>(
            R.layout.item_layout to "com.example.catflowforkotlin.RUserViewHolder"
        )


        recycler.layoutManager = LinearLayoutManager(this)
        var ad =  Radapter(holders)
        ad.v_list(listOb)
        recycler.adapter = ad


        listOb.v_list(true,{

            var items = mutableListOf<Cat>()
            for (i in 1..12){
                items.add(UserData("今天下雨了$i"))
            }

            return@v_list items
        })

        ad.v_didSelect {

            Toast.makeText(this,"${it}",Toast.LENGTH_SHORT).show()

            Router.Companion.push(Main2Activity::class.java)

        }

    }
}

class UserData(var name:String): Cat() {

    override val layoutIdentity: Int
        get() = R.layout.item_layout


    //点击事件表示
    var eventdentifier:Int = 0

}
class RUserViewHolder(viewItem: View) : RHolder(viewItem){

    val textView: TextView = viewItem.findViewById(R.id.text)

    override fun setData(item: Cat){

        if (item is UserData){

            var model = item as? UserData
            textView.setText(model?.name)

            model?.eventdentifier = 1


            textView.setOnClickListener {

                v_selectOb.v_on?.invoke()

            }

        }

    }

}


