package com.example.waiter

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.waiter.receiver.LowBatteryReceiver
import com.example.waiter.receiver.TimeTickReceiver

class MainActivity : AppCompatActivity() {

    lateinit var statusTv: TextView
    lateinit var timeTickReceiver: TimeTickReceiver
    lateinit var lowBatteryReceiver: LowBatteryReceiver
    lateinit var tiredOfWaitingButton: Button
    var minutes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusTv = findViewById(R.id.status_tv)
        tiredOfWaitingButton = findViewById(R.id.tired_of_waiting_button)
        timeTickReceiver = TimeTickReceiver()
        lowBatteryReceiver = LowBatteryReceiver()

        tiredOfWaitingButton.setOnClickListener{
            unregisterReceiver(timeTickReceiver)
            Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(timeTickReceiver, IntentFilter("android.intent.action.TIME_TICK"))
        registerReceiver(lowBatteryReceiver, IntentFilter("android.intent.action.BATTERY_LOW"))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(timeTickReceiver)
        unregisterReceiver(lowBatteryReceiver)
    }

    fun updateMinutes() {
        minutes += 1
        statusTv.text = "время созерцания: $minutes мин."
    }
}