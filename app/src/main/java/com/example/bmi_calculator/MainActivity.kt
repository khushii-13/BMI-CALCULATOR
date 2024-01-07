package com.example.bmi_calculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var wt= findViewById<EditText>(R.id.enterWeight)
        var ht = findViewById<EditText>(R.id.enterHeight)
        var checkbtn=findViewById<Button>(R.id.bmiCalculate)
        var answerid=findViewById<TextView>(R.id.answer)
        checkbtn.setOnClickListener {
            closeKeyBoard()
            val w = wt.text.toString().toFloat()
            var h = ht.text.toString().toFloat()
            h /= 100
            val ans = w/(h*h)
            val bmi = String.format("%.2f",ans).toFloat()
            answerid.text = display(ans)+bmi.toString()
            wt.text = null
            ht.text = null

        }
    }
    private fun display(bmi: Float) :String{

        if(bmi < 18.5){
            return   "UnderWeight BMI :"
        }else if(bmi in 18.5..24.9){
            return  "Healthy BMI : "
        }else{
            return  "OverWeight BMI : "
        }
    }
    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}