package com.example.milestone2task2_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class SwipeLayout: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_layout_example)

        var listView = findViewById<ListView>(R.id.swipe_layout_list_view)
        var adapter = SwipeLayoutAdapter(this)
        listView.adapter = adapter
    }

}

