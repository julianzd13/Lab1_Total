package com.example.lab1_total

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt_exe1.setOnClickListener {
            goToP1Activity()
        }
        bt_exe2.setOnClickListener {
            goToP2Activity()
        }
        bt_exe3.setOnClickListener {
            goToP3Activity()
        }
        bt_exe4.setOnClickListener {
            goToP4Activity()
        }
    }

    private fun goToP1Activity(){
        val intent = Intent(this, P1Activity::class.java)
        startActivity(intent)
        finish()
    }


    private fun goToP2Activity(){
        val intent = Intent(this, P2Activity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToP3Activity(){
        val intent = Intent(this, P3Activity::class.java)
        startActivity(intent)
        //finish()
    }

    private fun goToP4Activity(){
        val intent = Intent(this, P4Activity::class.java)
        startActivity(intent)
        finish()
    }



}
