package com.example.milestone2task2_3

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.panavtec.drawableview.DrawableView
import me.panavtec.drawableview.DrawableViewConfig


class DrawableViewSample: AppCompatActivity(){
    var config = DrawableViewConfig()
    lateinit var drawView: DrawableView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawable_view_example)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        drawView = findViewById<DrawableView>(R.id.drawable_view_sample_view)

        config.strokeColor = getColor(R.color.black)
        config.strokeWidth = 5f
        config.canvasHeight = height - 100
        config.canvasWidth = width
        config.minZoom = 1f
        config.maxZoom = 10f

        drawView.setConfig(config)
    }

    fun onBiggerClick(view: View){
        config.strokeWidth += 2
    }

    fun onSmallerClick(view: View){
        config.strokeWidth -= 2
    }

    fun onUndoClick(view: View){
        drawView.undo()
    }
}

