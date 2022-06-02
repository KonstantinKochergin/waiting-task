package com.example.waiter.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.widget.Toast
import com.example.waiter.R

class LowBatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, Resources.getSystem().getString(R.string.low_battery_text), Toast.LENGTH_LONG).show()
    }
}