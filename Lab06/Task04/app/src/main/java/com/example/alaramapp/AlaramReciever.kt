package com.example.alaramapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlaramReciever: BroadcastReceiver() {
    //<action android:name="com.tester.alarammanager"/>
    //When the event happen with this action name onRecieve will be call
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarammanager")){
            var intentData = intent.extras
            Toast.makeText(context,intentData!!.getString("Message"),Toast.LENGTH_LONG).show()
            val notify = Notifications()
            notify.Notify(context!!,intentData!!.getString("Message"),10)
        } else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            val alaramData = AlaramData(context!!)
            alaramData.setAlaram()
        }
    }
}