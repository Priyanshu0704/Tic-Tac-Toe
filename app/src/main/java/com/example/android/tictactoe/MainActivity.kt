package com.example.android.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

     private lateinit var arr : Array<IntArray>
     private var steps: Int = 0
     var setSymbol : Int = 0
     var setName1 : String? = null
     var setName2 : String? = null
     private val SHARE_URL = "https://covidtracker48.page.link/downlaod"


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.restart->recreate()
            R.id. exit->finishAffinity()
            R.id.share -> shareApp()
            R.id.link -> gitHubLink()
            R.id.change_players ->onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun shareApp(){
        /*val messageText = "Enjoy the fee TIC TAC TOE game with friends"+ SHARE_URL
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, messageText)
        sendIntent.type = "text/plain"
        val shareIntent = Intent.createChooser(sendIntent, "Share the App using")
        startActivity(shareIntent)*/
        Toast.makeText(this, "feature coming soon", Toast.LENGTH_SHORT).show()
    }

    fun gitHubLink(){
        val repoLink =
            Uri.parse("https://github.com/priyanshu-ui/Tic-Tac-Toe")
        val downloadApp = Intent(Intent.ACTION_VIEW,repoLink)
        if (downloadApp.resolveActivity(packageManager) != null) {
            startActivity(downloadApp)
        }
    }


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


        val intent: Intent = intent

        setName1 = intent.getStringExtra("p1")
        name1.text = setName1

        setName2 = intent.getStringExtra("p2")
        name2.text = setName2

        //TODO: This code snippet has been commented just for the sake of testing purpose
        //TODO: and could be modified to work properly
        setSymbol = intent.getIntExtra("c1",1)
        if (setSymbol == 1){
            chose1.setImageResource(R.drawable.cross)
            chose2.setImageResource(R.drawable.circle)
        }

        else{
            chose1.setImageResource(R.drawable.circle)
            chose2.setImageResource(R.drawable.cross)
        }


        val image11 :  TextView = findViewById(R.id.line_1_1)

        image11.setOnClickListener {
            step(it,0,0)
        }

        val image12 :  TextView = findViewById(R.id.line_1_2)

        image12.setOnClickListener {
            step(it,0,1)
        }

        val image13 : TextView = findViewById(R.id.line_1_3)

        image13.setOnClickListener {
            step(it,0,2)
        }

        val image21 :  TextView = findViewById(R.id.line_2_1)

        image21.setOnClickListener {
            step(it,1,0)
        }

        val image22 :  TextView = findViewById(R.id.line_2_2)

        image22.setOnClickListener {
            step(it,1,1)
        }


        val image23 :  TextView = findViewById(R.id.line_2_3)

        image23.setOnClickListener {
            step(it,1,2)
        }

        val image31 :  TextView = findViewById(R.id.line_3_1)

        image31.setOnClickListener {
            step(it,2,0)
        }

        val image32 : TextView = findViewById(R.id.line_3_2)

        image32.setOnClickListener {
            step(it,2,1)
        }


        val image33 :  TextView = findViewById(R.id.line_3_3)

        image33.setOnClickListener {
            step(it,2,2)
        }


       arr = Array(3){ IntArray(3) }
    }


    private fun step(v: View, row: Int, col: Int) {
        val view: TextView = v as TextView
        if ((view.text.toString()).isEmpty()) {
            if (setSymbol == 1) {
                when (steps % 2) {
                    0 -> {

                        view.text = " X"
                        arr[row][col] = 1

                    }
                    else -> {
                        view.text = " O"
                        arr[row][col] = 2

                    }
                }
                if (winCheck()) {

                    dialogBoxAfterGame(
                        1,
                        when (view.text.toString()) {
                            " X" -> setName1
                            else -> setName2
                        }!!
                    )
                    return
                }
            }
                else {
                    when (steps % 2) {
                        0 -> {

                            view.text = " O"
                            arr[row][col] = 1

                        }
                        else -> {
                            view.text = " X"
                            arr[row][col] = 2

                        }
                    }
                if (winCheck()) {

                    dialogBoxAfterGame(
                        1,
                        when (view.text.toString()) {
                            " X" -> setName2
                            else -> setName1
                        }!!
                    )
                    return
                }
                }
            }

            steps++

        if (steps == 9) {
            dialogBoxAfterGame(0)
        }
        }






    private fun winCheck(): Boolean {
        for (i in 0 until 3) {
            if (arr[i][0] == arr[i][1]
                && arr[i][0] == arr[i][2]
                && arr[i][0] != 0
            ) {
                return true
            }
        }
        for (i in 0 until 3) {
            if (arr[0][i] == arr[1][i]
                && arr[0][i] == arr[2][i]
                && arr[0][i] != 0
            ) {
                return true
            }
        }
        if (arr[0][0] == arr[1][1]
            && arr[0][0] == arr[2][2]
            && arr[0][0] != 0
        ) {
            return true
        }
        if (arr[0][2] == arr[1][1]
            && arr[0][2] == arr[2][0]
            && arr[0][2] != 0
        ) {
            return true
        }
        return false
    }

    private fun dialogBoxAfterGame(i: Int, a: String = "") {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)


        builder.setTitle(
            when (i) {
                1 -> "Winner!"
                else -> "Game Over"
            }
        )
        builder.setMessage(
            when (i) {
                1 -> "$a, You Won, Congrats!!!"
                else -> "The game ended in a draw"
            }
        )
        builder.setPositiveButton(
            "Restart"
        ) { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.cancel()
            recreate()
        }
        builder.setNeutralButton(
            "Change Players"
        ) { dialog: DialogInterface?, which: Int ->
            onBackPressed()
        }
        builder.setNegativeButton(
            "Exit Game"
        ) { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            finishAffinity()
        }
        builder.setCancelable(false)
        val dialog: AlertDialog = builder.create()
        if (!dialog.isShowing) {
            dialog.show()
        }
    }
}