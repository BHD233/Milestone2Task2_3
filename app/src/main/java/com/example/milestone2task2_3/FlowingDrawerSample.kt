package com.example.milestone2task2_3

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlin.random.Random

class FlowingDrawerSample: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flowing_drawer_sample)

        getInterface()
    }

    fun getInterface(){
        val mainLayout = findViewById<LinearLayout>(R.id.flowing_drawer_sample_main_layout)

        for (j in (0..20)){
            mainLayout.addView(getBaseAsset())
        }
    }


    fun getBaseAsset(): View {
        val asset = layoutInflater.inflate(R.layout.flowing_drawer_asset, null)

        val text1 = asset.findViewById<TextView>(R.id.flowing_drawer_text)
        text1.text = randomText(10)

        val img = asset.findViewById<ImageView>(R.id.flowing_drawer_sample_img)
        Glide.with(this).load(randomImageSource()).into(img)

        return asset
    }

    fun randomText(length: Int = 10): String{
        val alphabet: MutableList<String> = arrayListOf()

        for (i in 'a'..'z') {
            alphabet.add(i.toString())
        }
        alphabet.add(" ")

        var cur: String = ""
        for (i in 0..length - 1){
            cur += alphabet[Random.nextInt(alphabet.size - 1)]
        }

        return cur
    }

    fun randomInt(max: Int = 200): Int{
        return (Random.nextInt(max) + 10)
    }

    fun randomImageSource() : String{
        val preString : String = "https://api.adorable.io/avatar/"
        val lastString : String = ".png"

        var numImg = randomInt(200)

        return preString + numImg.toString() + numImg
    }

}

