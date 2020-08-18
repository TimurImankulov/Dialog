package com.example.lesson13

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners() {
        btnSave.setOnClickListener {
            createAlertDialog()
        }
        etDateOfBirth.setOnClickListener {
            createDatePickerDialog()
        }
    }

    private fun createDatePickerDialog() {
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            etDateOfBirth.setText(getString(R.string.date, dayOfMonth, month, year))
        }
        dialog.datePicker.maxDate = Date().time
        dialog.show()
    }

    private fun createAlertDialog() {
        val dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog))
        dialog.setTitle("Сохранить данные?")
        dialog.setPositiveButton("Да") { dialog, which ->
            saveData()
            createCustomDialog()
        }
        dialog.setNegativeButton("Нет") { dialog, which ->
        }
        dialog.show()
    }

    private fun createCustomDialog() {
        CustomDialog(this).show()
    }

    private fun saveData() {
        val preference = getSharedPreferences("Lesson13", Context.MODE_PRIVATE)

        preference.edit().putString("firstName", etFirstName.text.toString()).apply()
        preference.edit().putString("lastName", etLastName.text.toString()).apply()
    }
}