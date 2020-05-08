package com.example.milestone2task2_3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import com.lorentzos.flingswipe.SwipeFlingAdapterView.onFlingListener


class SwipeCardsSample: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_cards_sample)

        var context = this

        val flingContainer = findViewById<SwipeFlingAdapterView>(R.id.swipe_cards)

        var i = 0

        var al = ArrayList<String>()
        al.add("football")
        al.add("tennis")
        al.add("volleyball")
        al.add("basketball")
        al.add("ping pong")
        al.add("soccer")

        var arrayAdapter = ArrayAdapter<String>(this, R.layout.swipe_cards_item, R.id.swipe_cards_text, al)

        //set the listener and the adapter
        flingContainer.adapter = arrayAdapter

        flingContainer.setFlingListener(object:onFlingListener {
            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!")
                al.removeAt(0)
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {
                Toast.makeText(context, "Swipe Left!", Toast.LENGTH_SHORT).show();
            }

            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(context, "Swipe Right!", Toast.LENGTH_SHORT).show();
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
            }

            override fun onScroll(p0: Float) {
                //do something
            }
        })

    }
}