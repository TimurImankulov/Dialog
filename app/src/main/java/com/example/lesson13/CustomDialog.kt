package com.example.lesson13

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_custom.*

class CustomDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        setupListener()
    }

    private fun setupListener() {
        btnExit.setOnClickListener {
            dismiss()
        }
    }
}