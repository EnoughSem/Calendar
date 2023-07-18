package com.example.calendarapp

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date

data class StudiosJson(
    var id: Int,
    var task_name: String,
    var studio_name: String,
    var date_start: Date,
    var date_end: Date
)

class Studios(
    _id: Int,
    _task_name: String,
    _studio_name: String,
    _date_start: Date,
    _date_end: Date
) : Serializable {
    var Id = _id
    var Task_name = _task_name
    var Studio_name = _studio_name
    var Date_start = _date_start
    var Date_end = _date_end
}

data class StudiosNameListJson(var studio_id: Int, var studio_name: String)

class StudiosNameList(_studio_id: Int, _studio_name: String) {
    var Id = _studio_id
    var Studio_name = _studio_name
}

class StudiosNameListJsonAdapter(
    private val context: Context,
    private val array: ArrayList<StudiosNameListJson>
) :
    ArrayAdapter<StudiosNameListJson>(context, R.layout.item_list, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_list, null)

        val textView = view.findViewById<TextView>(R.id.name)

        textView.text = array[position].studio_name

        return view
    }
}

class StudiosJsonAdapter(
    private val context: Context,
    private val array: ArrayList<StudiosJson>
) :
    ArrayAdapter<StudiosJson>(context, R.layout.item_task, array) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_task, null)

        val dateFormat = DateTimeFormatter.ofPattern("dd.MM HH:mm")
        val task = view.findViewById<TextView>(R.id.studioTask)
        val timeStart = view.findViewById<TextView>(R.id.timeStart)

        task.text = array[position].task_name
        timeStart.text = "C " + array[position].date_start.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat) + " До " +array[position].date_end.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat)

        return view
    }
}

data class StudiosDateJson(var date_start: Date, var date_end: Date)