package com.example.android.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

     private lateinit var arr : Array<IntArray>

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
        val messageText = "Enjoy the fee TIC TAC TOE game with friends"
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, messageText)
        sendIntent.type = "text/plain"
        val shareIntent = Intent.createChooser(sendIntent, "Share the App using")
        startActivity(shareIntent)
    }

    fun gitHubLink(){
        val repoLink =
            Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu")
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

        //TODO: Getting the starting intent of the activity to get the player names. We used
        //TODO: getIntent() function in java but in kotlin we just call intent to get the
        //TODO: starting intent
        val intent: Intent = intent
        //TODO: Marking both Strings as String? as it shows that the name of the player could be
        //TODO: null

        //TODO: Using intent.getStringExtra() function to get the player names from the starting
        //TODO: intent using the key
        val setName1 : String? = intent.getStringExtra("p1")
        name1.text = setName1

        val setName2 : String? = intent.getStringExtra("p2")
        name2.text = setName2

        //TODO: This code snippet has been commented just for the sake of testing purpose
        //TODO: and could be modified to work properly
        val setSymbol : Int = intent.getIntExtra("c1",1)
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
            if (setName1 != null) {
                dialogBoxAfterGame(1,setName1)
            }
        }


       arr = Array(3){ IntArray(3) }
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