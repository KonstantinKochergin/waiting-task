package com.example.waiter.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.waiter.MainActivity

class TimeTickReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        (context as MainActivity).updateMinutes()
    }
}