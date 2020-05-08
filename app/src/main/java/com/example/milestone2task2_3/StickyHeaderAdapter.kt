package com.example.milestone2task2_3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.utils.LogcatLogger
import com.shuhart.stickyheader.StickyAdapter


interface Section {
    fun type(): Int
    fun sectionPosition(): Int
    fun getText(): String

    companion object {
        const val HEADER = 0
        const val ITEM = 1
        const val CUSTOM_HEADER = 2
    }
}

class SectionItem(private val section: Int, text: String) : Section {
    var curText = text
    override fun type(): Int {
        return Section.ITEM
    }

    override fun sectionPosition(): Int {
        return section
    }

    override fun getText(): String {
        return curText
    }
}

class SectionHeader(private val section: Int, text: String) : Section {
    var curText = text
    override fun type(): Int {
        return Section.HEADER
    }

    override fun sectionPosition(): Int {
        return section
    }

    override fun getText(): String {
        return curText
    }
}

class SectionAdapter(itemsText: ArrayList<String> = arrayListOf()) : StickyAdapter<ViewHolder, ViewHolder?>() {

    var curItemsText = itemsText

    var items: List<Section> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == Section.HEADER || viewType == Section.CUSTOM_HEADER) {
            HeaderViewholder(
                inflater.inflate(
                    com.example.milestone2task2_3.R.layout.sticky_header_header,
                    parent,
                    false
                )
            )
        } else ItemViewHolder(
            inflater.inflate(
                com.example.milestone2task2_3.R.layout.sticky_header_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val type = items[position].type()
        val section = items[position].sectionPosition()
        val text = items[position].getText()
        if (type == Section.HEADER) {
            (holder as HeaderViewholder).textView.text = text
        } else if (type == Section.ITEM) {
            (holder as ItemViewHolder).textView.text = text
        }

    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        return items[itemPosition].sectionPosition()
    }

    override fun onBindHeaderViewHolder(
        holder: ViewHolder,
        headerPosition: Int
    ) {
        if (headerPosition < curItemsText.size) {
            (holder as HeaderViewholder).textView.text = curItemsText[headerPosition]
            Log.i("BHD", headerPosition.toString())
        }
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): ViewHolder {
        return createViewHolder(parent, Section.HEADER)
    }

    class HeaderViewholder internal constructor(itemView: View) : ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(com.example.milestone2task2_3.R.id.sticky_header_header_text)
        }
    }

    class ItemViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(com.example.milestone2task2_3.R.id.sticky_header_item_text)
        }
    }
}