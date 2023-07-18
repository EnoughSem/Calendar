package com.example.calendarapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarapp.databinding.ActivityStudiosListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudiosListActivity : AppCompatActivity() {

    private lateinit var bilding: ActivityStudiosListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding = ActivityStudiosListBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        getStudioList(this)
    }

    private fun getStudioList(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            val url = "https://www.mamont-server.ru:8888/api/check_studio/"
            HttpClient().use { client ->
                val dataString = client.get<String>(url)
                val typeToken = object : TypeToken<ArrayList<StudiosNameListJson>>() {}.type
                val studiosList =
                    Gson().fromJson<ArrayList<StudiosNameListJson>>(dataString, typeToken)
                CoroutineScope(Dispatchers.Main).launch {
                    bilding.studiosList.isClickable = true
                    bilding.studiosList.adapter =
                        StudiosNameListJsonAdapter(context, studiosList)
                    bilding.studiosList.setOnItemClickListener { _, _, position, _ ->
                        openStudioCalendar(studiosList[position].studio_id)
                    }
                }
            }
        }
    }

    private fun openStudioCalendar(studio_id: Int){
        val intent = Intent(this, StudioCalendar::class.java)
        intent.putExtra(StudioCalendar.STUDIO ,studio_id.toString())
        startActivity(intent)
    }
}
