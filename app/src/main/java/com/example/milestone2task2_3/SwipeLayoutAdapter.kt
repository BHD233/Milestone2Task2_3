package com.example.milestone2task2_3

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.daimajia.swipe.SimpleSwipeListener
import com.daimajia.swipe.adapters.BaseSwipeAdapter
import java.nio.file.Files.delete


class SwipeLayoutAdapter(private val mContext: Context) : BaseSwipeAdapter() {
    override fun getSwipeLayoutResourceId(position: Int): Int {
        return com.example.milestone2task2_3.R.id.swipe_layout_swipe
    }

    override fun generateView(position: Int, parent: ViewGroup): View {
        val v: View =
            LayoutInflater.from(mContext).inflate(com.example.milestone2task2_3.R.layout.swipe_layout, null)
        val swipeLayout =
            v.findViewById<View>(getSwipeLayoutResourceId(position)) as com.daimajia.swipe.SwipeLayout
        swipeLayout.addSwipeListener(object : SimpleSwipeListener() {
            fun onOpen(layout: SwipeLayout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100)
                    .playOn(layout.findViewById(com.example.milestone2task2_3.R.id.delete))
            }
        })
        v.findViewById<LinearLayout>(com.example.milestone2task2_3.R.id.swipe_layout_main_layout)
            .setOnClickListener{
            Toast.makeText(mContext, "touch at " + position.toString(), Toast.LENGTH_SHORT).show()
            true
        }
        v.findViewById<View>(com.example.milestone2task2_3.R.id.delete)
            .setOnClickListener {
                Toast.makeText(mContext, "click delete", Toast.LENGTH_SHORT).show()
            }
        return v
    }

    override fun fillValues(position: Int, convertView: View) {
        val t = convertView.findViewById<View>(com.example.milestone2task2_3.R.id.swipe_layout_text) as TextView
        t.text = "Some text " + (position + 1).toString() + "."
    }

    override fun getCount(): Int {
        return 50
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}