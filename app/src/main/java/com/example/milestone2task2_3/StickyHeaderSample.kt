package com.example.milestone2task2_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shuhart.stickyheader.StickyHeaderItemDecorator
import java.util.*
import kotlin.collections.ArrayList


class StickyHeaderSample: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sticky_header_sample)

        var recyclerView = findViewById<RecyclerView>(R.id.sticky_header_recycle_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this));

        val dividerDecorator =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerDecorator)

        var data = randomData(30)
        var subData: MutableList<String> = arrayListOf()

        var cur = ""

        var listSection = object : ArrayList<Section>() {
            init {
                var section = -1
                //            add(new CustomHeader());
                for (i in 0..data.size - 1) {
                    var header = data[i].get(0).toString()
                    if (header != cur){
                        section++
                        subData.add(header)
                        cur = header
                        add(SectionHeader(section, header))
                    }
                    add(SectionItem(section, data[i]))
                }
            }
        }

        val adapter = SectionAdapter(subData as ArrayList<String>)
        adapter.items = listSection

        recyclerView.adapter = adapter

        val decorator = StickyHeaderItemDecorator(adapter)
        decorator.attachToRecyclerView(recyclerView)
    }

    fun randomData(length: Int = 20): ArrayList<String>{
        var result: MutableList<String> = arrayListOf()

        for (i in (0..length - 1)){
            result.add(randomText(6))
        }

        result.sort()

        return result as ArrayList<String>
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()
        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }

        var cur: String = ""
        for (i in 0..length){
            cur += alphabet[Random().nextInt(alphabet.size - 1)]
        }

        return cur
    }
}