package com.example.assignmentn3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand = ""
    private var secOperand = ""
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is Button) {

            var text = resultTextView.text.toString()
            val buttonNumber = clickedView.text.toString()

            if(text == "0"){
                text = ""
            }

            val result = text + buttonNumber

            resultTextView.text = result
        }
    }


    fun operationClick(clickedView: View) {
        if (clickedView is Button) {

            val firstOperandText = resultTextView.text.toString()

            if (firstOperandText.isNotEmpty()) {
                operand = firstOperandText
            }

            this.operation = clickedView.text.toString()

            this.resultTextView.text = ""

        }
    }


    fun equalsClick(clickedView: View) {
        if (clickedView is Button) {
            val secondOperandText = resultTextView.text.toString()
            if (secondOperandText.isNotEmpty()) {
                secOperand = secondOperandText
            }

            when (this.operation) {
                "+" -> resultTextView.text =
                    (this.operand.toFloat() + secOperand.toFloat()).toString()
                "-" -> resultTextView.text =
                    (this.operand.toFloat() - secOperand.toFloat()).toString()
                "*" -> resultTextView.text =
                    (this.operand.toFloat() * secOperand.toFloat()).toString()
                "/" -> resultTextView.text =
                    (this.operand.toFloat() / secOperand.toFloat()).toString()
            }
        }
    }

    fun clear (clickedView: View) {
        if (clickedView is Button) {
            this.resultTextView.text = "0"

        }
    }


}