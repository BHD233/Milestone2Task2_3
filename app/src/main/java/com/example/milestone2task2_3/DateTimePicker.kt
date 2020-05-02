package com.example.milestone2task2_3

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*

class DateTimePicker: AppCompatActivity(){
    var now = Calendar.getInstance()

    var dpd: DatePickerDialog = DatePickerDialog()

    var tpd: TimePickerDialog = TimePickerDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date_time_selector)

        createDateClick()
        createTimeClick()
    }

    fun createDateClick(){
        val layout = findViewById<LinearLayout>(R.id.date_layout)

        val textView = findViewById<TextView>(R.id.date_text_view)

        layout.setOnClickListener(View.OnClickListener { v: View->
            if (dpd == null){
                dpd = DatePickerDialog.newInstance(
                    DatePickerDialog.OnDateSetListener{view1: DatePickerDialog?, year: Int, month: Int, dayOfMonth: Int ->
                        textView.text = dayOfMonth.toString() + "/" + month.toString() + "/" + year.toString()
                    },
                    now[Calendar.YEAR],
                    now[Calendar.MONTH],
                    now[Calendar.DAY_OF_MONTH]
                )
            } else {
                dpd.initialize(
                    DatePickerDialog.OnDateSetListener{view1: DatePickerDialog?, year: Int, month: Int, dayOfMonth: Int->
                        textView.text = dayOfMonth.toString() + "/" + month.toString() + "/" + year.toString()
                    },
                    now[Calendar.YEAR],
                    now[Calendar.MONTH],
                    now[Calendar.DAY_OF_MONTH]
                )
            }
            dpd.show(supportFragmentManager, "test")
        })
    }

    fun createTimeClick(){
        val layout = findViewById<LinearLayout>(R.id.time_layout)

        val textView = findViewById<TextView>(R.id.time_text_view)

        layout.setOnClickListener(View.OnClickListener { v: View->
            if (tpd == null){
                tpd = TimePickerDialog.newInstance(
                    TimePickerDialog.OnTimeSetListener { view1: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int ->
                        textView.text = hourOfDay.toString() + ":" + minute.toString()
                    },
                    now[Calendar.HOUR],
                    now[Calendar.MINUTE],
                    true        //is 24 hour
                )
            } else {
                tpd.initialize(
                    TimePickerDialog.OnTimeSetListener { view1: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int ->
                        textView.text = hourOfDay.toString() + ":" + minute.toString()
                    },
                    now[Calendar.HOUR],
                    now[Calendar.MINUTE],
                    now[Calendar.SECOND],
                    true        //is 24 hour
                )
            }
            tpd.show(supportFragmentManager, "test")
        })
    }
}

