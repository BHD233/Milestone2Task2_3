package com.example.milestone2task2_3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.rd.PageIndicatorView
import java.util.*


class PagerIndicatorSample : AppCompatActivity() {
    private var pageIndicatorView: PageIndicatorView? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paper_indicator_sample)
        initViews()
    }


    private fun initViews() {
        val adapter = PagerIndicatorAdapter()
        adapter.data = createPageList()
        val pager = findViewById<ViewPager>(R.id.pager_indicator_viewpager)
        pager.adapter = adapter
        var pageIndicatorView = findViewById<PageIndicatorView>(R.id.pager_indicator_indicator)

        pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { /*empty*/
            }

            override fun onPageSelected(position: Int) {
                pageIndicatorView.setSelection(position)
            }

            override fun onPageScrollStateChanged(state: Int) { /*empty*/
            }
        })
    }

    private fun createPageList(): List<View> {
        val pageList: MutableList<View> =
            ArrayList()
        pageList.add(createPageView(R.color.red))
        pageList.add(createPageView(R.color.orangeBackground))
        pageList.add(createPageView(R.color.greenLight))
        pageList.add(createPageView(R.color.yellow))
        pageList.add(createPageView(R.color.blueLight))
        return pageList
    }

    private fun createPageView(color: Int): View {
        val view = View(this)
        view.setBackgroundColor(getResources().getColor(color))
        return view
    }

}