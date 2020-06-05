package com.example.android.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player1Name : String? = player1Name()
        val player2Name : String? = player2Name()
        val choose : Int = player1click()

        val start : Button = findViewById(R.id.start)
        start.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    fun player1Name(): String? {

        val player1: EditText = findViewById(R.id.name_1)

        val name1: String = player1.text.toString()

        return name1
    }

    fun player1click(): Int {

        var i  = 0

        val player1Cross : ImageButton = findViewById(R.id.choose_cross)

        val player1Circle : ImageButton = findViewById(R.id.choose_circle)

        player1Cross.setOnClickListener {
            Toast.makeText(this,"you selected cross",Toast.LENGTH_SHORT).show()
            i = 1
            player1Circle.isEnabled = false
            player1Circle.isClickable = false
        }

        player1Circle.setOnClickListener {
            Toast.makeText(this,"you selected circle",Toast.LENGTH_SHORT).show()
            i = 2
            player1Cross.isEnabled = false
            player1Cross.isClickable = false
        }
         return i
    }

    fun player2Name(): String? {

        val player2: EditText = findViewById(R.id.name_1)

        val name2: String = player2.text.toString()

        return name2
    }


}