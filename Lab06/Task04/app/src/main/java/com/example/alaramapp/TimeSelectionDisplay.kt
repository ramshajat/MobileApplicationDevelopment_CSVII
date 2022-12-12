package com.example.alaramapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class TimeSelectionDisplay: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var dialogView = inflater!!.inflate(R.layout.time_selection,container,false)
        var selectBTN = dialogView.findViewById(R.id.timeSelectionBTN) as Button
        var timePicker = dialogView.findViewById(R.id.timePicker) as TimePicker

        selectBTN.setOnClickListener {
            //current main activity
            val mainActivity = activity as MainActivity
            mainActivity.setTime(timePicker.hour, timePicker.minute)
            this.dismiss()
        }
        return dialogView
    }

}