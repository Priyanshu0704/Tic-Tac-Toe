package com.example.android.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Choosing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing)




        val start : Button = findViewById(R.id.start)
        start.setOnClickListener {

            if (player1Name().isNotEmpty() && player2Name().isNotEmpty()) {
                val player1Name: String = player1Name()
                val player2Name: String = player2Name()
                val choose: Int = player1click()
                Toast.makeText(this,"Player 1 starts first", Toast.LENGTH_SHORT).show()

                val intent: Intent = Intent(Intent(this, MainActivity::class.java))

                intent.putExtra("p1", player1Name)
                intent.putExtra("p2", player2Name)
                intent.putExtra("c1", choose)
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "player names cannot be empty", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun player1Name(): String {

        val player1: EditText = findViewById(R.id.name_1)

        val name1: String = player1.text.toString()

        return name1
    }

    fun player1click(): Int {

        var i  = 0

        val player1Cross : CheckBox = findViewById(R.id.choose_cross)

        val player1Circle : CheckBox = findViewById(R.id.choose_circle)

        player1Cross.setOnClickListener {
            Toast.makeText(this,"Player 1 starts first", Toast.LENGTH_SHORT).show()
            i = 1
            player1Circle.isEnabled = false
            player1Circle.isClickable = false
        }

        player1Circle.setOnClickListener {
            Toast.makeText(this,"Player 1 starts first", Toast.LENGTH_SHORT).show()
            i = 2
            player1Cross.isEnabled = false
            player1Cross.isClickable = false
        }
        return i
    }

    fun player2Name(): String {

        val player2: EditText = findViewById(R.id.name_2)

        val name2: String = player2.text.toString()

        return name2
    }
}