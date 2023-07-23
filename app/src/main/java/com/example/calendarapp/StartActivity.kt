package com.example.calendarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val openStudios = findViewById<Button>(R.id.openStudios)
        openStudios.setOnClickListener {
            val intent = Intent(this, StudiosListActivity::class.java)
            startActivity(intent)
        }

        val openEquipment = findViewById<Button>(R.id.openEquipment)
        openEquipment.setOnClickListener {
            val intent = Intent(this, EquipmentsListActivity::class.java)
            startActivity(intent)
        }

        val openTasks = findViewById<Button>(R.id.openTasks)
        openTasks.setOnClickListener {
            val intent = Intent(this, TasksListActivity::class.java)
            startActivity(intent)
        }
    }

}