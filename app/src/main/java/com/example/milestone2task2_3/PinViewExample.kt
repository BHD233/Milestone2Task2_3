package com.example.milestone2task2_3

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.chaos.view.PinView


class PinViewExample: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pin_view_example)

        var pinView = findViewById<PinView>(R.id.pin_view_example_input)
        pinView.setAnimationEnable(true)

        pinView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (pinView.text?.length == 5){

                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(pinView.getWindowToken(), 0)

                    pinView.clearFocus()
                    //proccess on done

                    showAlert()
                }
            }

        })
    }
    fun showAlert(){
        val pDialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
        pDialog.progressHelper.barColor = getColor(R.color.orangeBackground)
        pDialog.titleText = "Loading"
        pDialog.setCancelable(true)
        pDialog.show()

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                pDialog.cancel()
            }
        }.start()
    }

}
