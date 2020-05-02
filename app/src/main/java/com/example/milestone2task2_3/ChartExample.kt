package com.example.milestone2task2_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.formatter.ColumnChartValueFormatter
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.ColumnChartView
import kotlin.random.Random

class ChartExample: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chart_example)

        getInterface()
    }

    fun getInterface() {
        val barChart = findViewById<ColumnChartView>(R.id.chart_example_chart)
        val xAxisValue = arrayListOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
        val xAxis: MutableList<AxisValue> = arrayListOf()

        //set data
        val columns: MutableList<Column> = arrayListOf<Column>()
        for (i in (0..11)) {
            var column =
                Column(
                    arrayListOf(
                        SubcolumnValue(Random.nextInt(20) * 1f + 10, getColor(R.color.blueBackground))
                    )
                )

            xAxis.add(AxisValue(i.toFloat(), (i+1).toString().toCharArray()))

            columns.add(column)
        }
        val data = ColumnChartData(columns)
        data.setStacked(true)

        //set axis
        var axisX = Axis(xAxis)
        axisX.name = "month"
        axisX.textColor = getColor(R.color.black)
        axisX.textSize = 18

        data.axisXBottom = axisX

        //title for y axis
        val yAxis: MutableList<AxisValue> = arrayListOf()
        for (i in (0..40) step 5){
            yAxis.add(AxisValue(i.toFloat(), (i.toString() + "C").toCharArray()))
        }

        var axisY = Axis(yAxis)
        axisY.textColor = getColor(R.color.black)
        axisY.textSize = 18

        data.axisYLeft = axisY


        barChart.columnChartData = data
    }
}

