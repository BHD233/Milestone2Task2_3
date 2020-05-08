package com.example.milestone2task2_3

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable
import com.jpardogo.android.googleprogressbar.library.GoogleMusicDicesDrawable
import com.jpardogo.android.googleprogressbar.library.NexusRotationCrossDrawable

class GoogleProgressBarSample: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.google_progress_bar_sample)

        var progressBar1 = findViewById<ProgressBar>(R.id.google_progress_bar1)
        progressBar1.setIndeterminateDrawable(
            GoogleMusicDicesDrawable.Builder()
                .build()
        )

        var progressBar2 = findViewById<ProgressBar>(R.id.google_progress_bar2)
        progressBar2.setIndeterminateDrawable(
            FoldingCirclesDrawable.Builder(this)
                .build()
        )

        var progressBar3 = findViewById<ProgressBar>(R.id.google_progress_bar3)
        progressBar3.setIndeterminateDrawable(
            NexusRotationCrossDrawable.Builder(this)
                .build()
        )

        var progressBar4 = findViewById<ProgressBar>(R.id.google_progress_bar4)
        progressBar4.setIndeterminateDrawable(
            ChromeFloatingCirclesDrawable.Builder(this)
                .build()
        )
    }
}