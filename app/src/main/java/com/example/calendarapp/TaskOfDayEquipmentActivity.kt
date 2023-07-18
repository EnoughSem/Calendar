package com.example.calendarapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarapp.databinding.ActivityTaskOfDayBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskOfDayEquipmentActivity : AppCompatActivity() {

    private lateinit var bilding: ActivityTaskOfDayBinding

    companion object {
        const val EQUIPMENT = "Equipment_id"
        const val DATE = "Date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding = ActivityTaskOfDayBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        createList(this)
    }

    private fun createList(context : Context){
        CoroutineScope(Dispatchers.Default).launch {
            val equipment_id = intent.getStringExtra(EQUIPMENT)
            val date = intent.getStringExtra(DATE)
            val url = "https://www.mamont-server.ru:8888/api/check_equipment/$equipment_id/$date/$date"
            HttpClient().use {client ->
                val dataString = client.get<String>(url)
                val typeToken = object : TypeToken<ArrayList<EquipmentsJson>>() {}.type
                val studiosList =
                    Gson().fromJson<ArrayList<EquipmentsJson>>(dataString, typeToken)
                CoroutineScope(Dispatchers.Main).launch {
                    bilding.listView.isClickable = false
                    bilding.listView.adapter = EquipmentsJsonAdapter(context, studiosList)
                }
            }
        }
    }
}