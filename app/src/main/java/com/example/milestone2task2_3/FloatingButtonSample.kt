package com.example.milestone2task2_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class FloatingButtonSample: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.floating_button_sample)

        MaterialTapTargetPrompt.Builder(this)
            .setTarget(R.id.floating_button_fake)
            .setPrimaryText("See more option")
            .setSecondaryText("Tap the icon to expand more option")
            .setPrimaryTextSize(60f)
            .setSecondaryTextSize(40f)
            .setMaxTextWidth(1000f)
            .show()
    }
}

