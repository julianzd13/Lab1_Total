package com.example.lab1_total

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_p2.*

class P2Activity : AppCompatActivity() {


    private var resultconvert: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p2)



        bt_convert.setOnClickListener {

            val valueto = et_value.text.toString()
            val currency1 = sp_currency_one.selectedItem.toString()
            val currency2 = sp_currency_two.selectedItem.toString()



            if (currency1 == "Dollar (US)" && currency2 == "Euro"){
                resultconvert = USDtoEU(valueto.toDouble())
            }
            if (currency1 == "Dollar (US)" && currency2 == "Peso (CO)"){
                resultconvert = USDtoCO(valueto.toDouble())
            }
            if (currency1 == "Peso (CO)" && currency2 == "Euro"){
                resultconvert = COtoEU(valueto.toDouble())
            }
            if (currency1 == "Peso (CO)" && currency2 == "Dollar (US)"){
                resultconvert = COtoUSD(valueto.toDouble())
            }
            if (currency1 == "Euro" && currency2 == "Dollar (US)"){
                resultconvert = EUtoUSD(valueto.toDouble())
            }
            if (currency1 == "Euro" && currency2 == "Peso (CO)"){
                resultconvert = EUtoCO(valueto.toDouble())
            }
            if (currency1 == currency2 || valueto.isEmpty() || currency1.isEmpty() || currency2.isEmpty()) {
                Toast.makeText(this, getText(R.string.error_1), Toast.LENGTH_SHORT).show()
            }

            tv_result.text = getString(R.string.result) + Constantes.SPACE + String.format("%.3f", resultconvert)


        }

        bt_return.setOnClickListener {
            goToMainActivity()
        }


    }

    private fun USDtoEU (a: Double) : Double{
        return a/1.12
    }

    private fun EUtoUSD (a: Double) : Double{
        return  a*1.12
    }

    private fun USDtoCO (a: Double) : Double{
        return  a*3350
    }

    private fun COtoUSD (a: Double) : Double{
        return  a/3350
    }

    private fun COtoEU (a: Double) : Double{
        return  a/3739
    }

    private fun EUtoCO (a: Double) : Double{
        return  a*3739
    }

    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}
