package com.example.android.tictactoe

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * getting the name of player 1 and 2 from activity choosing
        * getting player choice from activity choosing
         */
        val name1 : TextView = findViewById(R.id.name_1)
        val name2 : TextView = findViewById(R.id.name_2)
        val chose1 : ImageView = findViewById(R.id.img_1)
        val chose2 : ImageView = findViewById(R.id.img_2)

        //for using function from Choosing class
        val choose = Choosing()

        val setName1 : String = choose.player1Name()
        name1.text = setName1

        val setName2 : String = choose.player2Name()
        name2.text = setName2

        val setSymbol : Int = choose.player1click()
        if (setSymbol == 1){
            chose1.setImageResource(R.drawable.cross)
            chose2.setImageResource(R.drawable.circle)
        }

        else{
            chose1.setImageResource(R.drawable.circle)
            chose2.setImageResource(R.drawable.cross)
        }


        val image11 : ImageButton = findViewById(R.id.line_1_1)

        image11.setOnClickListener {

        }

        val image12 : ImageButton = findViewById(R.id.line_1_2)

        image12.setOnClickListener {

        }

        val image13 : ImageButton = findViewById(R.id.line_1_3)

        image13.setOnClickListener {

        }

        val image21 : ImageButton = findViewById(R.id.line_2_1)

        image21.setOnClickListener {

        }

        val image22 : ImageButton = findViewById(R.id.line_2_2)

        image22.setOnClickListener {

        }


        val image23 : ImageButton = findViewById(R.id.line_2_3)

        image23.setOnClickListener {

        }

        val image31 : ImageButton = findViewById(R.id.line_3_1)

        image31.setOnClickListener {

        }

        val image32 : ImageButton = findViewById(R.id.line_3_2)

        image32.setOnClickListener {

        }


        val image33 : ImageButton = findViewById(R.id.line_3_3)

        image33.setOnClickListener {

        }

    }


}