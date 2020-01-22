package com.example.lab1_total

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_p4.*

class P4Activity : AppCompatActivity() {


    private var colorcount : Int = 0
    private var calcuresis: String = Constantes.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p4)

        var colorband : String = Constantes.EMPTY
        var resis : String = Constantes.EMPTY
        var resis2 : String = Constantes.EMPTY
        var resis3 : String = Constantes.EMPTY
        var decidot : String = Constantes.EMPTY

        bt_color_one.setOnClickListener {

            if (colorband != "one") colorcount = 0
            colorband = "one"
            colorcount = colorcount + 1
            resis = colorcalcu(colorband, colorcount)
            tv_result.text = resis

        }
        bt_color_two.setOnClickListener {

            if (colorband != "two") colorcount = 0
            colorband = "two"
            colorcount = colorcount + 1
            resis2 = colorcalcu(colorband, colorcount)

            tv_result.text = resis + resis2

        }
        bt_color_three.setOnClickListener {

            if (colorband != "three") colorcount = 0

            if (resis.isNotEmpty() && resis2.isNotEmpty()) {
                colorband = "three"
                colorcount = colorcount + 1


                resis3 = colorcalcu(colorband, colorcount)
                tv_result.text = ((resis + resis2).toDouble()*resis3.toDouble()).toString()

            }
        }
        bt_color_four.setOnClickListener {

            if (colorband != "four") colorcount = 0

            if (resis.isNotEmpty() && resis3.isNotEmpty() || resis2.isNotEmpty() && resis3.isNotEmpty()) {
                colorband = "four"
                colorcount = colorcount + 1

                tv_result.text =((resis + resis2).toDouble() * resis3.toDouble()).toString() +
                        colorcalcu(colorband,colorcount)
            }else{
                colorband = "four"
                colorcount = colorcount + 1

                tv_result.text =resis + resis2 + colorcalcu(colorband,colorcount)
            }

        }

        bt_clear.setOnClickListener {

            bt_color_one.setBackgroundColor(resources.getColor(R.color.honeydew))
            bt_color_two.setBackgroundColor(resources.getColor(R.color.honeydew))
            bt_color_three.setBackgroundColor(resources.getColor(R.color.honeydew))
            bt_color_four.setBackgroundColor(resources.getColor(R.color.honeydew))

            colorcount = 0
            tv_result.text = Constantes.EMPTY

        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bt_calcu.setOnClickListener {

            val valueresis = et_value.text.toString()

            if (valueresis.isNotEmpty()) {

                bt_color_one.setBackgroundColor(resources.getColor(R.color.honeydew))
                bt_color_two.setBackgroundColor(resources.getColor(R.color.honeydew))
                bt_color_three.setBackgroundColor(resources.getColor(R.color.honeydew))
                bt_color_four.setBackgroundColor(resources.getColor(R.color.honeydew))

                colorcount = 0
                tv_result.text = Constantes.EMPTY

                if (valueresis.length > 1) {

                    decidot = valueresis.substring(1, valueresis.length)    // para saber si es decimal
                    decidot = decidot.substring(0, 1)

                }

                if (decidot == ".") {

                    decidot = valueresis.substring(0,1)

                    if (decidot != "0" && valueresis.length == 3 ){
                        colorcalcu("three",12)
                        decidot = valueresis.substring(0, valueresis.length-2)
                        colorcalcu("one", decidot.toInt())
                        decidot = valueresis.substring(2, valueresis.length)
                        colorcalcu("two", decidot.toInt())
                    }
                    if (decidot == "0" && valueresis.length == 4){
                        colorcalcu("three",13)
                        decidot = valueresis.substring(2, valueresis.length-1)
                        colorcalcu("one", decidot.toInt())
                        decidot = valueresis.substring(3, valueresis.length)
                        colorcalcu("two", decidot.toInt())
                    }


                }else if(valueresis.length >= 2 ) {

                    decidot = valueresis.substring(0, 1)
                    colorcalcu("one", decidot.toInt())

                    decidot = valueresis.substring(1, 2)
                    colorcalcu("two", decidot.toInt())
                    if (decidot == "0") colorcalcu("two", 10)
                    if (valueresis.length == 2) colorcalcu("three", 10)

                    if (valueresis.length > 2 && valueresis.substring(2, 3) == "0") {
                        decidot = valueresis.substring(2, valueresis.length)
                        decidot = "1" + decidot

                        if (decidot.toDouble() % 10.0 == 0.0) colorcalcu("three", 1)
                        if (decidot.toDouble() % 100.0 == 0.0) colorcalcu("three", 2)
                        if (decidot.toDouble() % 1000.0 == 0.0) colorcalcu("three", 3)
                        if (decidot.toDouble() % 10000.0 == 0.0) colorcalcu("three", 4)
                        if (decidot.toDouble() % 100000.0 == 0.0) colorcalcu("three", 5)
                        if (decidot.toDouble() % 1000000.0 == 0.0) colorcalcu("three", 6)
                        if (decidot.toDouble() % 10.0 != 0.0 && decidot.toDouble() % 100.0 != 0.0 && decidot.toDouble() % 1000.0 != 0.0 &&
                            decidot.toDouble() % 10000.0 != 0.0 && decidot.toDouble() % 100000.0 != 0.0 && decidot.toDouble() % 1000000.0 != 0.0){

                            Toast.makeText(this, getText(R.string.error_value), Toast.LENGTH_SHORT).show()
                            bt_color_one.setBackgroundColor(resources.getColor(R.color.honeydew))
                            bt_color_two.setBackgroundColor(resources.getColor(R.color.honeydew))
                            bt_color_three.setBackgroundColor(resources.getColor(R.color.honeydew))
                            bt_color_four.setBackgroundColor(resources.getColor(R.color.honeydew))

                            colorcount = 0
                            tv_result.text = Constantes.EMPTY

                        }

                    }

                    if (valueresis.length > 2 && valueresis.substring(2, 3) != "0"){
                        Toast.makeText(this, getText(R.string.error_value), Toast.LENGTH_SHORT).show()
                        bt_color_one.setBackgroundColor(resources.getColor(R.color.honeydew))
                        bt_color_two.setBackgroundColor(resources.getColor(R.color.honeydew))
                        bt_color_three.setBackgroundColor(resources.getColor(R.color.honeydew))
                        bt_color_four.setBackgroundColor(resources.getColor(R.color.honeydew))

                        colorcount = 0
                        tv_result.text = Constantes.EMPTY
                    }
                }
            }


        }

        bt_return.setOnClickListener {
            goToMainActivity()
        }

    }

    private fun colorcalcu (a: String, b: Int): String{
        if (b == 1 )
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.sienna))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.sienna))
            if (a== "three")bt_color_three.setBackgroundColor(resources.getColor(R.color.sienna))
            if (a== "four")bt_color_four.setBackgroundColor(resources.getColor(R.color.sienna))

            calcuresis = "1"
            if (a == "three" )calcuresis = "10"
            if (a == "four") calcuresis = "+-1%"
        }
        if (b == 2 )
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.red))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.red))
            if (a== "three")bt_color_three.setBackgroundColor(resources.getColor(R.color.red))
            if (a== "four")bt_color_four.setBackgroundColor(resources.getColor(R.color.red))

            calcuresis = "2"
            if (a == "three" )calcuresis = "100"
            if (a == "four")
            {
                calcuresis = "+-2%"
                colorcount = 11

            }
        }
        if (b == 3)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.orange))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.orange))
            if (a== "three")bt_color_three.setBackgroundColor(resources.getColor(R.color.orange))

            calcuresis = "3"
            if (a == "three" )calcuresis = "1000"
        }
        if (b == 4)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.yellow))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.yellow))
            if (a== "three")bt_color_three.setBackgroundColor(resources.getColor(R.color.yellow))

            calcuresis = "4"
            if (a == "three" )calcuresis = "10000"
        }
        if (b == 5)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.green))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.green))
            if (a== "three")bt_color_three.setBackgroundColor(resources.getColor(R.color.green))

            calcuresis = "5"
            if (a == "three" )calcuresis = "100000"
        }
        if (b == 6)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.blue))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.blue))
            if (a== "three"){
                bt_color_three.setBackgroundColor(resources.getColor(R.color.blue))
                colorcount = 9
            }

            calcuresis = "6"
            if (a == "three" )calcuresis = "1000000"
        }
        if (b == 7)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.purple))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.purple))

            calcuresis = "7"

        }
        if (b == 8)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.gray))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.gray))

            calcuresis = "8"
            if (a == "three" )calcuresis = "0.01"
        }
        if (b == 9)
        {
            if(a == "one")bt_color_one.setBackgroundColor(resources.getColor(R.color.white))
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.white))

            calcuresis = "9"

            if(a == "one") {
                colorcount = 0
            }
        }
        if (b == 10)
        {
            if (a== "two")bt_color_two.setBackgroundColor(resources.getColor(R.color.black))

            calcuresis = "0"
            colorcount = 0

            if (a== "three"){
                bt_color_three.setBackgroundColor(resources.getColor(R.color.black))
                calcuresis = "1"
                colorcount = 11
            }

        }
        if (b == 12 )
        {
            if (a == "three"){
                bt_color_three.setBackgroundColor(resources.getColor(R.color.gold))
                calcuresis = "0.1"
            }
            if (a == "four"){
                bt_color_four.setBackgroundColor(resources.getColor(R.color.gold))
                calcuresis = "+-5%"
            }

        }
        if (b == 13 )
        {
            if (a == "three"){
                bt_color_three.setBackgroundColor(resources.getColor(R.color.silver))
                calcuresis = "0.01"
                colorcount = 0
            }
            if (a == "four") {
                bt_color_four.setBackgroundColor(resources.getColor(R.color.silver))
                calcuresis = "+-10%"
                colorcount = 0
            }

        }

        return calcuresis
    }


    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

