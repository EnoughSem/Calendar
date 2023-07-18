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

data class EquipmentsJson(
    var id: Int,
    var task_name: String,
    var equipment_name: String,
    var date_start: Date,
    var date_end: Date
)

class Equipments(
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

data class EquipmentsNameListJson(var equipment_id: Int, var equipment_name: String)

class EquipmentsNameListJsonAdapter(
    private val context: Context,
    private val array: ArrayList<EquipmentsNameListJson>
) :
    ArrayAdapter<EquipmentsNameListJson>(context, R.layout.item_list, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_list, null)

        val textView = view.findViewById<TextView>(R.id.name)

        textView.text = array[position].equipment_name

        return view
    }
}

class EquipmentsJsonAdapter(
    private val context: Context,
    private val array: ArrayList<EquipmentsJson>
) :
    ArrayAdapter<EquipmentsJson>(context, R.layout.item_task, array) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inFlater = LayoutInflater.from(context)
        val view = inFlater.inflate(R.layout.item_task, null)

        val dateFormat = DateTimeFormatter.ofPattern("dd.MM HH:mm")
        val task = view.findViewById<TextView>(R.id.studioTask)
        val timeStart = view.findViewById<TextView>(R.id.timeStart)

        task.text = array[position].task_name
        timeStart.text = "С " + array[position].date_start.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat) + " До " + array[position].date_end.toInstant()
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime().format(dateFormat)

        return view
    }
}