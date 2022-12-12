package com.example.alaramapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    lateinit var alaramTimeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alaramTimeTV = findViewById(R.id.alaramTimeTV)
        val alaramData = AlaramData(applicationContext)
        alaramTimeTV.text = alaramData.getHour().toString() + ":" + alaramData.getMinute().toString()

    }

    fun showTimePickerDialog(view: View){
        val selectTime = TimeSelectionDisplay()
        val timeFragManager: FragmentManager = supportFragmentManager
        selectTime.show(timeFragManager,"Select time")
    }

    fun setTime(hour:Int , minute: Int){
        alaramTimeTV.text = hour.toString() + ":" + minute.toString()
        val alaramData = AlaramData(applicationContext)
        alaramData.saveAlaramData(hour,minute)
        alaramData.setAlaram()
    }
}