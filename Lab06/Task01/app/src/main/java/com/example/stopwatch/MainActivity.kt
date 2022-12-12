package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var secondsValue: Int = 0
    var minValue: Int = 0
    var hoursValue: Int = 0
    lateinit var hoursTV: TextView
    lateinit var minsTV: TextView
    lateinit var secsTV: TextView
    var isRun: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hoursTV = findViewById(R.id.hourTV)
        minsTV = findViewById(R.id.minTV)
        secsTV = findViewById(R.id.secondsTV)

        val thread = Thread(Runnable {
            while (true){
                if(isRun){
                    runOnUiThread{
                        secondsValue++
                        secsTV.text = secondsValue.toString()
                        if(secondsValue==60){
                            minValue++
                            minsTV.text = minValue.toString()
                            secondsValue = 0
                        }
                        if(minValue==60){
                            hoursValue++
                            hoursTV.text = hoursValue.toString()
                        }
                    }
                    Thread.sleep(1000)
                }
            }
        })
        thread.start()
    }

    fun start(view: View){
       isRun = true
    }

    fun stop(view:View){
        isRun = false
    }

    fun reset(view: View){
        secondsValue = 0
        minValue = 0
        hoursValue = 0

        secsTV.text = secondsValue.toString()
        minsTV.text = minValue.toString()
        hoursTV.text = hoursValue.toString()
    }
}