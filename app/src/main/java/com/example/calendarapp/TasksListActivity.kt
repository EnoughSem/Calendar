package com.example.calendarapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarapp.databinding.ActivityTasksListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasksListActivity : AppCompatActivity() {

    private lateinit var bilding: ActivityTasksListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding = ActivityTasksListBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        getTasksList(this)
    }

    private fun getTasksList(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            val url = "https://www.mamont-server.ru:8888/api/projects"
            HttpClient().use { client ->
                val dataString = client.get<String>(url)
                val typeToken = object : TypeToken<ArrayList<ProjectsJson>>() {}.type
                val studiosList =
                    Gson().fromJson<ArrayList<ProjectsJson>>(dataString, typeToken)
                CoroutineScope(Dispatchers.Main).launch {
                    bilding.List.isClickable = true
                    bilding.List.adapter =
                        ProjectsListJsonAdapter(context, studiosList)
                    bilding.List.setOnItemClickListener { _, _, position, _ ->
                        openTaskCalendar(studiosList[position].id, studiosList[position].project_name)
                    }
                }
            }
        }
    }

    private fun openTaskCalendar(task_id: Int, task_name: String){
        val intent = Intent(this, TasksCalendar::class.java)
        intent.putExtra(TasksCalendar.TASK_ID ,task_id.toString())
        intent.putExtra(TasksCalendar.TASK_NAME,task_name)
        startActivity(intent)
    }
}