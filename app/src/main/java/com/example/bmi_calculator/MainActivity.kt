package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var wt= findViewById<EditText>(R.id.enterWeight)
        var ht = findViewById<EditText>(R.id.enterHeight)
        var checkbtn=findViewById<Button>(R.id.bmiCalculate)
        var answerid=findViewById<TextView>(R.id.answer)
        checkbtn.setOnClickListener {

            val w= wt.text.toString().toFloat()
            var h = ht.text.toString().toFloat()
            h /= 100
            val ans= w/(h*h)
            val bmi =String.format("%.2f",ans).toFloat()
            answerid.text="Your Bmi is "+bmi.toString()



        }
    }
}