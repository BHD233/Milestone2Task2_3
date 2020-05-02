package com.example.milestone2task2_3

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu


class FloatingMenuButton: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.floating_menu_button)

        var icon = ImageView(this)
        icon.setBackgroundResource(R.drawable.clock)

        var params = LinearLayout.LayoutParams(80,80)

        var icon2 = ImageView(this)
        icon2.setBackgroundResource(R.drawable.clock)
        icon2.layoutParams = params

        var icon3 = ImageView(this)
        icon3.setBackgroundResource(R.drawable.calendar)
        icon3.layoutParams = params

        var icon4 = ImageView(this)
        icon4.setBackgroundResource(R.drawable.trash)
        icon4.layoutParams = params

        icon4.setOnClickListener {

        }

        var floatingButton = FloatingActionButton.Builder(this).setContentView(icon).build()
        var actionItem = FloatingActionMenu.Builder(this)
            .addSubActionView(icon2)
            .addSubActionView(icon3)
            .addSubActionView(icon4)
            .attachTo(floatingButton).build()

    }
}