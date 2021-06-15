package com.app.ageapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btnDatePicker)
        button.setOnClickListener { view ->
            clickDatePicker(view)

        }


    }

    fun clickDatePicker(view: View) {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, seletYear, seletMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "The chosen year is $seletYear,the chosen month is $seletMonth,the chosen day is $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()
                val selectedDate = "$selectedDayOfMonth/${seletMonth+1}/$seletYear"

                val selectdate :TextView = findViewById(R.id.selectdate)
                selectdate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInminutes = currentDate!!.time / 60000

                val differenceInMinutes = currentDateInminutes - selectedDateInMinutes

                val selectedDateinMinutes:TextView = findViewById(R.id.selecteDateinMinutes)
                selectedDateinMinutes.setText(differenceInMinutes.toString())




            },
            year,
            month,
            day
        ).show()


    }

}