package com.example.lab1_total

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_p3.*

class P3Activity : AppCompatActivity() {


    var ope : String = Constantes.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p3)

        var expre : String = Constantes.EMPTY
        var expredel : String = Constantes.EMPTY
        var num1 : String = Constantes.EMPTY
        var num2 : String = Constantes.EMPTY
        var result : Double = 0.0
        var flagnum : Int = 0
        var flagope : Int = 0

//////////////////BOTONES//////////////////////////////////////////////

        bt_0.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "0"
                expre = expre + "0"
                tv_table.text = expre
            }else {
                num1 = num1 + "0"
                expre = expre + "0"
                tv_table.text = expre
            }
        }
        bt_1.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "1"
                expre = expre + "1"
                tv_table.text = expre
            }else {
                num1 = num1 + "1"
                expre = expre + "1"
                tv_table.text = expre
            }
        }
        bt_2.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "2"
                expre = expre + "2"
                tv_table.text = expre
            }else {
                num1 = num1 + "2"
                expre = expre + "2"
                tv_table.text = expre
            }
        }
        bt_3.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "3"
                expre = expre + "3"
                tv_table.text = expre

            }else {
                num1 = num1 + "3"
                expre = expre + "3"
                tv_table.text = expre
            }
        }
        bt_4.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "4"
                expre = expre + "4"
                tv_table.text = expre
            }else {
                num1 = num1 + "4"
                expre = expre + "4"
                tv_table.text = expre
            }
        }
        bt_5.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "5"
                expre = expre + "5"
                tv_table.text = expre

            }else {
                num1 = num1 + "5"
                expre = expre + "5"
                tv_table.text = expre

            }
        }
        bt_6.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "6"
                expre = expre + "6"
                tv_table.text = expre

            }else {
                num1 = num1 + "6"
                expre = expre + "6"
                tv_table.text = expre

            }
        }
        bt_7.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "7"
                expre = expre + "7"
                tv_table.text = expre

            }else {
                num1 = num1 + "7"
                expre = expre + "7"
                tv_table.text = expre

            }
        }
        bt_8.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "8"
                expre = expre + "8"
                tv_table.text = expre

            }else {
                num1 = num1 + "8"
                expre = expre + "8"
                tv_table.text = expre
            }
        }
        bt_9.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "9"
                expre = expre + "9"
                tv_table.text = expre
            }else {
                num1 = num1 + "9"
                expre = expre + "9"
                tv_table.text = expre
            }
        }

        bt_return.setOnClickListener {
            goToMainActivity()
        }


        bt_clear.setOnClickListener {
            num1 = Constantes.EMPTY
            num2 = Constantes.EMPTY
            ope = Constantes.EMPTY
            expre = Constantes.EMPTY
            tv_table.text = Constantes.EMPTY
            tv_result.text = Constantes.EMPTY
            flagnum = 0
            flagope = 0
        }

        bt_del.setOnClickListener {

            if (expre.length > 0) {
                expredel = expre.substring(expre.length-1, expre.length)
                if (expredel == "+" || expredel == "-" || expredel == "*" || expredel == "/") {
                    ope = Constantes.EMPTY
                    expre = expre.substring(0, expre.length-1)
                    flagope = 0
                    flagnum = 0

                }else{
                    if (flagnum == 1)
                    {
                        expre = expre.substring(0, expre.length-1)
                        num2 = expre
                    }
                    if(flagnum == 0){
                        expre = expre.substring(0, expre.length-1)
                        num1 = expre
                    }
                }
            }

            tv_table.text = expre
        }

        bt_equ.setOnClickListener {
            if (num2.isNotEmpty()) {
                if (ope == "+") {
                    result = calculator(num1.toDouble(), num2.toDouble())
                }
                if (ope == "-") {
                    result = calculator(num1.toDouble(), num2.toDouble())
                }
                if (ope == "*") {
                    result = calculator(num1.toDouble(), num2.toDouble())
                }
                if (ope == "/") {
                    result = calculator(num1.toDouble(), num2.toDouble())
                }
            }
            tv_table.text = expre
            tv_result.text = result.toString()

            num1 = result.toString()
            num2 = Constantes.EMPTY
            ope = Constantes.EMPTY
            expre = result.toString()
            flagnum = 1
            flagope = 0
        }

        bt_dot.setOnClickListener {
            if (flagnum == 1){
                num2 = num2 + "."
                expre = expre + "."
                tv_table.text = expre

            }else {
                num1 = num1 + "."
                expre = expre + "."
                tv_table.text = expre

            }
        }
//////////////////////////OPERADORES////////////////////////////////////////////////////////////////

        bt_add.setOnClickListener {
            if (num1 == Constantes.EMPTY) {
                Toast.makeText(this, getText(R.string.error_1), Toast.LENGTH_SHORT).show()
            }
            if (flagope == 1 && num2.isNotEmpty()) {

                result = calculator(num1.toDouble(), num2.toDouble())

                flagope = 1
                flagnum = 1
                num1 = result.toString()
                num2 = Constantes.EMPTY
                ope = "+"
                expre = expre + "+"
                tv_table.text = expre
                tv_result.text = result.toString()
            }
            if(flagope == 0 )
            {
                ope = "+"
                expre = expre + "+"
                tv_table.text = expre
                flagnum = 1
                flagope = 1
            }
        }

        bt_subt.setOnClickListener {
            if (num1 == Constantes.EMPTY) {
                Toast.makeText(this, getText(R.string.error_1), Toast.LENGTH_SHORT).show()
            }
            if (flagope == 1 && num2.isNotEmpty()) {

                result = calculator(num1.toDouble(), num2.toDouble())

                flagope = 1
                flagnum = 1
                num1 = result.toString()
                num2 = Constantes.EMPTY
                ope = "-"
                expre = expre + "-"
                tv_table.text = expre
                tv_result.text = result.toString()

            }
            if(flagope == 0)
            {
                ope = "-"
                expre = expre + "-"
                tv_table.text = expre
                flagnum = 1
                flagope = 1
            }
        }

        bt_mult.setOnClickListener {
            if (num1 == Constantes.EMPTY) {
                Toast.makeText(this, getText(R.string.error_1), Toast.LENGTH_SHORT).show()
            }
            if (flagope == 1 && num2.isNotEmpty()) {

                result = calculator(num1.toDouble(), num2.toDouble())

                flagope = 1
                flagnum = 1
                num1 = result.toString()
                num2 = Constantes.EMPTY
                ope = "*"
                expre = expre + "*"
                tv_table.text = expre
                tv_result.text = result.toString()

            }
            if(flagope == 0)
            {
                ope = "*"
                expre = expre + "*"
                tv_table.text = expre

                flagnum = 1
                flagope = 1
            }
        }

        bt_div.setOnClickListener {
            if (num1 == Constantes.EMPTY) {
                Toast.makeText(this, getText(R.string.error_1), Toast.LENGTH_SHORT).show()
            }
            if (flagope == 1 && num2.isNotEmpty() ) {

                result = calculator(num1.toDouble(), num2.toDouble())

                flagope = 1
                flagnum = 1
                num1 = result.toString()
                num2 = Constantes.EMPTY
                ope = "/"
                expre = expre + "/"
                tv_table.text = expre
                tv_result.text = result.toString()
            }
            if(flagope == 0)
            {
                ope = "/"
                expre = expre + "/"
                tv_table.text = expre

                flagnum = 1
                flagope = 1
            }
        }

    }

    private fun calculator (a: Double, b : Double) : Double {

        var c : Double = 0.0
        if (ope == "+") {
            c = a + b
        }
        if (ope == "-") {
            c = a - b
        }
        if (ope == "*") {
            c= a * b
        }
        if (ope == "/") {
            c = a / b
        }
        return c
    }

    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}


