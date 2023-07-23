package com.example.calendarapp

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date

data class TasksJson(
    var task_id: Int,
    var task_name: String,
    var date_start: Date,
    var date_stop: Date,
    var procent: Int
)

class Tasks(
    _id: Int,
    _task_name: String,
    _equipment_name: String,
    _date_start: Date,
    _date_end: Date
) : Serializable {
    var Id = _id
    var Task_name = _task_name
    var Equipment_name = _equipment_name
    var Date_start = _date_start
    var Date_end = _date_end
}

data class TasksNameListJson(var task_id: Int, var task_name: String)

class ProjectsListJsonAdapter(
    private val context: Context,
    private val array: ArrayList<ProjectsJson>
) :
    ArrayAdapter<ProjectsJson>(context, R.layout.item_list, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_list, null)

        val textView = view.findViewById<TextView>(R.id.name)

        textView.text = array[position].project_name

        return view
    }
}

class TasksJsonAdapter(
    private val context: Context,
    private val array: ArrayList<TasksJson>
) :
    ArrayAdapter<TasksJson>(context, R.layout.item_task_progres, array) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_task_progres, null)

        val dateFormat = DateTimeFormatter.ofPattern("dd.MM HH:mm")
        val task = view.findViewById<TextView>(R.id.studioTask)
        val timeStart = view.findViewById<TextView>(R.id.timeStart)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        task.text = array[position].task_name
        timeStart.text = "С " + array[position].date_start.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat) + " До " + array[position].date_stop.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat)
        progressBar.progress = array[position].procent

        return view
    }
}

data class ProjectsJson (
    var id: Int,
    var project_name: String,
    var date_start: Date,
    var date_stop: Date,
    var procent: Int,
    var producer_name: String
        )

