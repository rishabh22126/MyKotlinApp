package com.example.mykotlinapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd: Button
    lateinit var btnSubtraction: Button
    lateinit var btnMultiplication: Button
    lateinit var btnDivision: Button

    lateinit var etA: EditText
    lateinit var etB: EditText
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSubtraction = findViewById(R.id.btn_Subtraction)
        btnMultiplication = findViewById(R.id.btn_Multiplication)
        btnDivision = findViewById(R.id.btn_Division)

        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        tvResult = findViewById(R.id.result_tv)

        btnAdd.setOnClickListener(this)
        btnSubtraction.setOnClickListener(this)
        btnMultiplication.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var a = etA.text.toString().toDoubleOrNull()
        var b = etB.text.toString().toDoubleOrNull()

        // Check for empty input or invalid numbers
        if (a == null || b == null) {
            tvResult.text = "Please enter valid numbers."
            return
        }

        var result = 0.0
        when (v?.id) {
            R.id.btn_add -> {
                result = a + b
            }
            R.id.btn_Subtraction -> {
                result = a - b
            }
            R.id.btn_Multiplication -> {
                result = a * b
            }
            R.id.btn_Division -> {
                if (b == 0.0) {
                    tvResult.text = "Division by zero is not allowed."
                    return
                }
                result = a / b
            }
        }

        tvResult.text = "Result is $result"
    }
}