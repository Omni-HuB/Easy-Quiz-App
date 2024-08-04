package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnStart : Button = findViewById(R.id.btnStart)
        val enterName : EditText = findViewById(R.id.enterName)

        btnStart.setOnClickListener {

            if(enterName.text.isEmpty()){
                Toast.makeText(this,
                    " Please enter NAME ", Toast.LENGTH_SHORT).show()
            }else{

                val intent  = Intent(this, QQ1::class.java)

                intent.putExtra(QuestionsObjects.USER_NAME, enterName.text.toString())
                startActivity(intent)
                //finish()

            }
        }
    }
}