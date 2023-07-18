package com.example.calendarapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarapp.databinding.ActivityEquipmentsListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EquipmentsListActivity : AppCompatActivity() {

    private lateinit var bilding: ActivityEquipmentsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding = ActivityEquipmentsListBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        getEquipmentsList(this)
    }

    private fun getEquipmentsList(context : Context) {
        CoroutineScope(Dispatchers.Default).launch {
            val url = "https://www.mamont-server.ru:8888/api/check_equipment/"
            HttpClient().use { client ->
                val dataString = client.get<String>(url)
                val typeToken = object : TypeToken<ArrayList<EquipmentsNameListJson>>() {}.type
                val studiosList =
                    Gson().fromJson<ArrayList<EquipmentsNameListJson>>(dataString, typeToken)
                CoroutineScope(Dispatchers.Main).launch {
                    bilding.List.isClickable = true
                    bilding.List.adapter =
                        EquipmentsNameListJsonAdapter(context, studiosList)
                    bilding.List.setOnItemClickListener { _, _, position, _ ->
                        openEquipmentCalendar(studiosList[position].equipment_id)
                    }
                }
            }
        }
    }

    private fun openEquipmentCalendar(equipment_id : Int){
        val intent = Intent(this, EquipmentCalendar::class.java)
        intent.putExtra(EquipmentCalendar.EQUIPMENT ,equipment_id.toString())
        startActivity(intent)
    }
}