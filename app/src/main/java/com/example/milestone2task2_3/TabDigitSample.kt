package com.example.milestone2task2_3

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.asp.fliptimerviewlibrary.CountDownClock
import kotlinx.android.synthetic.main.tab_digit_sample.*

class TabDigitSample: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_digit_sample)

        val typeface = ResourcesCompat.getFont(this, R.font.roboto_bold)

        timerProgramCountdown.setCustomTypeface(typeface!!)
        timerProgramCountdown.startCountDown(700000)
        timerProgramCountdown.setCountdownListener(object : CountDownClock.CountdownCallBack {
            override fun countdownAboutToFinish() {
                //TODO Add your code here
            }

            override fun countdownFinished() {
            }
        })
    }
}