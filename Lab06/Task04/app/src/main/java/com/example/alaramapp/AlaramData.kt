package com.example.alaramapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import java.util.*

class AlaramData {

    // context is used for using system service for alaram manager
    var context:Context?=null
    var sharedPref: SharedPreferences?=null

    constructor(context:Context){
        this.context = context
        sharedPref = context.getSharedPreferences("ref" , Context.MODE_PRIVATE)
    }

    fun saveAlaramData(hours: Int , minutes: Int){
        var editor = sharedPref!!.edit()
        editor.putInt("Hour" , hours)
        editor.putInt("Minute" , minutes)
        editor.commit()
    }

    fun getHour(): Int {
        return sharedPref!!.getInt("Hour" , 0)
    }

    fun getMinute(): Int {
        return sharedPref!!.getInt("Minute" , 0)
    }

    fun setAlaram(){
        val hours: Int = getHour()
        val minutes: Int = getMinute()

        val calender = Calendar.getInstance()
        calender.set(Calendar.HOUR_OF_DAY,hours)
        calender.set(Calendar.MINUTE,minutes)
        calender.set(Calendar.SECOND,0)

        var intent: Intent = Intent(context,AlaramReciever::class.java)
        intent.putExtra("Message" , "Alaram Time")
        intent.action = "com.tester.alarammanager"

        val pendingIntent: PendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val alaramManager = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alaramManager.setRepeating(AlarmManager.RTC_WAKEUP,calender.timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent)
    }
}