package com.example.kotlincard_footer

import android.os.Bundle
import android.view.View

import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class MainActivity : AppCompatActivity(),ClickListener {
    override fun itemClicked(view: View?, position: Int) {
        Toast.makeText(
            view!!.getContext(),
            "Position:-" + Integer.toString(position),
            Toast.LENGTH_SHORT
        ).show()
    }


        val dataList = ArrayList<Data>()
        var recyclerView: RecyclerView? = null
        var myAdapter: HeaderAdapter? = null
        val main: LinearLayout? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            recyclerView = findViewById(R.id.recycler_view) as RecyclerView

            DataSet()
            myAdapter = HeaderAdapter(dataList)
        myAdapter!!.setClickListener(this)

            val layoutManager = LinearLayoutManager(applicationContext)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.itemAnimator = DefaultItemAnimator()
            recyclerView!!.adapter = myAdapter

        }

        fun DataSet() {

            var item = Data(R.drawable.one, "Roll1", "price is 550 Doller", R.drawable.play)
            dataList.add(item)

            item = Data(R.drawable.two, "Cake2", "price is 50", R.drawable.play)
            dataList.add(item)

            item = Data(R.drawable.three, "Cake2", "price is 50", R.drawable.play)
            dataList.add(item)

            item = Data(R.drawable.four, "Pineapple", "price is 200 doller", R.drawable.play)
            dataList.add(item)

        }
    }

