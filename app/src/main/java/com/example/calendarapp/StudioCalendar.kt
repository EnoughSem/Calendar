package com.example.calendarapp

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.Calendar
import java.util.concurrent.TimeUnit


class StudioCalendar : AppCompatActivity() {

    companion object {
        const val STUDIO = "Studio_id"
    }

    private lateinit var day1: TextView
    private lateinit var day2: TextView
    private lateinit var day3: TextView
    private lateinit var day4: TextView
    private lateinit var day5: TextView
    private lateinit var day6: TextView
    private lateinit var day7: TextView
    private lateinit var day8: TextView
    private lateinit var day9: TextView
    private lateinit var day10: TextView
    private lateinit var day11: TextView
    private lateinit var day12: TextView
    private lateinit var day13: TextView
    private lateinit var day14: TextView
    private lateinit var day15: TextView
    private lateinit var day16: TextView
    private lateinit var day17: TextView
    private lateinit var day18: TextView
    private lateinit var day19: TextView
    private lateinit var day20: TextView
    private lateinit var day21: TextView
    private lateinit var day22: TextView
    private lateinit var day23: TextView
    private lateinit var day24: TextView
    private lateinit var day25: TextView
    private lateinit var day26: TextView
    private lateinit var day27: TextView
    private lateinit var day28: TextView
    private lateinit var day29: TextView
    private lateinit var day30: TextView
    private lateinit var day31: TextView
    private lateinit var day32: TextView
    private lateinit var day33: TextView
    private lateinit var day34: TextView
    private lateinit var day35: TextView
    private lateinit var calendarArray: Array<TextView>
    private lateinit var startDate: String
    private lateinit var endDate: String
    private lateinit var startMonth: LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studio_calendar)
        setCalendar()
        getDate()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCalendar() {

        day1 = findViewById(R.id.TV1)
        day1.setOnClickListener {
            openTaskOfDayActivity(0)
        }
        day2 = findViewById(R.id.TV2)
        day2.setOnClickListener {
            openTaskOfDayActivity(1)
        }
        day3 = findViewById(R.id.TV3)
        day3.setOnClickListener {
            openTaskOfDayActivity(2)
        }
        day4 = findViewById(R.id.TV4)
        day4.setOnClickListener {
            openTaskOfDayActivity(3)
        }
        day5 = findViewById(R.id.TV5)
        day5.setOnClickListener {
            openTaskOfDayActivity(4)
        }
        day6 = findViewById(R.id.TV6)
        day6.setOnClickListener {
            openTaskOfDayActivity(5)
        }
        day7 = findViewById(R.id.TV7)
        day7.setOnClickListener {
            openTaskOfDayActivity(6)
        }
        day8 = findViewById(R.id.TV8)
        day8.setOnClickListener {
            openTaskOfDayActivity(7)
        }
        day9 = findViewById(R.id.TV9)
        day9.setOnClickListener {
            openTaskOfDayActivity(8)
        }
        day10 = findViewById(R.id.TV10)
        day10.setOnClickListener {
            openTaskOfDayActivity(9)
        }
        day11 = findViewById(R.id.TV11)
        day11.setOnClickListener {
            openTaskOfDayActivity(10)
        }
        day12 = findViewById(R.id.TV12)
        day12.setOnClickListener {
            openTaskOfDayActivity(11)
        }
        day13 = findViewById(R.id.TV13)
        day13.setOnClickListener {
            openTaskOfDayActivity(12)
        }
        day14 = findViewById(R.id.TV14)
        day14.setOnClickListener {
            openTaskOfDayActivity(13)
        }
        day15 = findViewById(R.id.TV15)
        day15.setOnClickListener {
            openTaskOfDayActivity(14)
        }
        day16 = findViewById(R.id.TV16)
        day16.setOnClickListener {
            openTaskOfDayActivity(15)
        }
        day17 = findViewById(R.id.TV17)
        day17.setOnClickListener {
            openTaskOfDayActivity(16)
        }
        day18 = findViewById(R.id.TV18)
        day18.setOnClickListener {
            openTaskOfDayActivity(17)
        }
        day19 = findViewById(R.id.TV19)
        day19.setOnClickListener {
            openTaskOfDayActivity(18)
        }
        day20 = findViewById(R.id.TV20)
        day20.setOnClickListener {
            openTaskOfDayActivity(19)
        }
        day21 = findViewById(R.id.TV21)
        day21.setOnClickListener {
            openTaskOfDayActivity(20)
        }
        day22 = findViewById(R.id.TV22)
        day22.setOnClickListener {
            openTaskOfDayActivity(21)
        }
        day23 = findViewById(R.id.TV23)
        day23.setOnClickListener {
            openTaskOfDayActivity(22)
        }
        day24 = findViewById(R.id.TV24)
        day24.setOnClickListener {
            openTaskOfDayActivity(23)
        }
        day25 = findViewById(R.id.TV25)
        day25.setOnClickListener {
            openTaskOfDayActivity(24)
        }
        day26 = findViewById(R.id.TV26)
        day26.setOnClickListener {
            openTaskOfDayActivity(25)
        }
        day27 = findViewById(R.id.TV27)
        day27.setOnClickListener {
            openTaskOfDayActivity(26)
        }
        day28 = findViewById(R.id.TV28)
        day28.setOnClickListener {
            openTaskOfDayActivity(27)
        }
        day29 = findViewById(R.id.TV29)
        day29.setOnClickListener {
            openTaskOfDayActivity(28)
        }
        day30 = findViewById(R.id.TV30)
        day30.setOnClickListener {
            openTaskOfDayActivity(29)
        }
        day31 = findViewById(R.id.TV31)
        day31.setOnClickListener {
            openTaskOfDayActivity(30)
        }
        day32 = findViewById(R.id.TV32)
        day32.setOnClickListener {
            openTaskOfDayActivity(31)
        }
        day33 = findViewById(R.id.TV33)
        day33.setOnClickListener {
            openTaskOfDayActivity(32)
        }
        day34 = findViewById(R.id.TV34)
        day34.setOnClickListener {
            openTaskOfDayActivity(33)
        }
        day35 = findViewById(R.id.TV35)
        day35.setOnClickListener {
            openTaskOfDayActivity(34)
        }

        calendarArray = arrayOf(
            day1,
            day2,
            day3,
            day4,
            day5,
            day6,
            day7,
            day8,
            day9,
            day10,
            day11,
            day12,
            day13,
            day14,
            day15,
            day16,
            day17,
            day18,
            day19,
            day20,
            day21,
            day22,
            day23,
            day24,
            day25,
            day26,
            day27,
            day28,
            day29,
            day30,
            day31,
            day32,
            day33,
            day34,
            day35
        )

        val calendar = Calendar.getInstance()
        val today = LocalDate.of(2023, 4, 12)
        startMonth = today.minusDays((today.dayOfWeek.value - 1).toLong())
        startDate = startMonth.dayOfMonth.toString() + "-"+ startMonth.monthValue + "-"+ startMonth.year.toString()
        val end = startMonth.plusDays(34)
        endDate = end.dayOfMonth.toString() + "-"+ end.monthValue + "-"+ end.year.toString()
        day1.text = startMonth.dayOfMonth.toString()
        for (i in 1 until calendarArray.size) {
            calendarArray[i].text = startMonth.plusDays(i.toLong()).dayOfMonth.toString()
        }
        val week1 = findViewById<TextView>(R.id.Week1)
        val week2 = findViewById<TextView>(R.id.Week2)
        val week3 = findViewById<TextView>(R.id.Week3)
        val week4 = findViewById<TextView>(R.id.Week4)
        val week5 = findViewById<TextView>(R.id.Week5)
        val array : Array<TextView> = arrayOf(week1,week2,week3,week4,week5)

        calendar.set(today.year,today.monthValue,today.dayOfMonth)
        val weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR)-4
        for(i in 0 until array.size)
            array[i].text = (weekOfYear+i).toString()

        val dateTV = findViewById<TextView>(R.id.DateTV)
        when(today.monthValue){
            1 -> dateTV.text = "Январь " + today.year.toString()
            2 -> dateTV.text = "Февраль " + today.year.toString()
            3 -> dateTV.text = "Март " + today.year.toString()
            4 -> dateTV.text = "Апрель " + today.year.toString()
            5 -> dateTV.text = "Май " + today.year.toString()
            6 -> dateTV.text = "Июнь " + today.year.toString()
            7 -> dateTV.text = "Июль " + today.year.toString()
            8 -> dateTV.text = "Август " + today.year.toString()
            9 -> dateTV.text = "Сентябрь " + today.year.toString()
            10 -> dateTV.text = "Октябрь " + today.year.toString()
            11 -> dateTV.text = "Ноябрь " + today.year.toString()
            12 -> dateTV.text = "Декабрь " + today.year.toString()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDate() {
        CoroutineScope(Dispatchers.Default).launch {
            val studioId = intent.getStringExtra(STUDIO)
            val url = "https://www.mamont-server.ru:8888/api/check_studio/$studioId/$startDate/$endDate"
            HttpClient().use { client ->
                val dataString = client.get<String>(url)
                val typeToken = object : TypeToken<ArrayList<StudiosJson>>() {}.type
                val studiosList = Gson().fromJson<ArrayList<StudiosJson>>(dataString, typeToken)
                withContext(Dispatchers.Main) {
                    calendarSchedule(studiosList)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calendarSchedule(studiosDateArray: ArrayList<StudiosJson>){
        val red = Color.rgb(232,91,93)
        val yellow = Color.rgb(	255,	228,136)
        val blue = Color.rgb(		102,	217,255)
        val today = LocalDate.of(2023, 4, 12)
        studiosDateArray.forEach{date ->
            for (i in calendarArray.indices){
                @Suppress("DEPRECATION")
                if (calendarArray[i].text ==  date.date_start.date.toString()){
                    if (date.date_start.hours == 0 && date.date_start.minutes == 0)
                        calendarArray[i].setBackgroundColor(red)
                    else
                        calendarArray[i].setBackgroundColor(yellow)
                    val diff = TimeUnit.MILLISECONDS.toDays(date.date_end.time - date.date_start.time).toInt()
                    if (i+diff <  calendarArray.size-1) {
                        for (j in 1 .. diff)
                            calendarArray[i+j].setBackgroundColor(red)
                        calendarArray[i+diff].setBackgroundColor(yellow)
                    }
                    else{
                        for (j in i until calendarArray.size)
                            calendarArray[j].setBackgroundColor(red)
                    }
                    break
                }
            }
        }
        calendarArray[today.dayOfWeek.value - 1].setBackgroundColor(blue)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun openTaskOfDayActivity(day:Int){
        val studioId = intent.getStringExtra(STUDIO)
        val intent = Intent(this, TaskOfDayStudioActivity::class.java)
        val date = startMonth.plusDays(day.toLong())
        val dateStr = date.dayOfMonth.toString() + "-"+ date.monthValue + "-"+ date.year.toString()
        intent.putExtra(TaskOfDayStudioActivity.DATE, dateStr)
        intent.putExtra(TaskOfDayStudioActivity.STUDIO, studioId)
        startActivity(intent)
    }
}