package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class wifi : AppCompatActivity() {
    private lateinit var wifiSwitch: Switch
    private lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        val b = findViewById<TextView>(R.id.textView6)
        val intent= intent
        var output=intent.getStringExtra("a")
        System.out.println(output)
        b.text=output.toString()

        if(output!=null){
        registerReceiver(this.mBatteryInfoReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))}
        else{
            var txtBatteryStatus = findViewById<TextView>(R.id.textView7)
            txtBatteryStatus.text=("null").toString()

        }

        val w = findViewById<TextView>(R.id.textView9)
        val i= intent
        var o=intent.getStringExtra("hh")
        System.out.println(o)
        w.text=o.toString()




        wifiSwitch = findViewById(R.id.wifi_switch)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                wifiManager.isWifiEnabled = true
                wifiSwitch.text = "WiFi is ON"
            } else {
                wifiManager.isWifiEnabled = false
                wifiSwitch.text = "WiFi is OFF"
            }
        }
    }
    private val mBatteryInfoReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var txtBatteryStatus = findViewById<TextView>(R.id.textView7)
            val level = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)
            val scale = intent!!.getIntExtra(BatteryManager.EXTRA_SCALE,-1)
            System.out.println(level)
            System.out.println(scale)

            txtBatteryStatus.text=level.toString()

        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }

    private val wifiStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN)

            when (wifiStateExtra) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    wifiSwitch.isChecked = true
                    wifiSwitch.text = "WiFi is ON"
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    wifiSwitch.isChecked = false
                    wifiSwitch.text = "WiFi is OFF"
                }
            }
        }
    }
}