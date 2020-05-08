package com.example.milestone2task2_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import com.baoyz.widget.PullRefreshLayout
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView

class PullToRefreshSample: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_to_refresh_sample)

        var mainLayout = findViewById<PullRefreshLayout>(R.id.swipeRefreshLayout)

        mainLayout.setOnRefreshListener(PullRefreshLayout.OnRefreshListener {
            mainLayout.postDelayed(Runnable { mainLayout.setRefreshing(false) }, 3000)
        })

        mainLayout.setRefreshing(false)

        var shimmerText = findViewById<ShimmerTextView>(R.id.pull_to_refresh_shimmer_text)

        var shimer = Shimmer()
        shimer.direction = Shimmer.ANIMATION_DIRECTION_LTR
        shimer.duration = 2000
        shimer.startDelay = 1000

        shimer.start(shimmerText)
    }
}

