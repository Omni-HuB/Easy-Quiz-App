package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvScore : TextView = findViewById(R.id.tv_score)

        val btnFinish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(QuestionsObjects.USER_NAME)
        tvScore.text = intent.getStringExtra(QuestionsObjects.CORRECT_ANSWERS)

        val totalQuestions =  intent.getIntExtra(QuestionsObjects.TOTAL_QUESTIONS, 0)
        val correctAns = intent.getIntExtra(QuestionsObjects.CORRECT_ANSWERS, 0)

        tvScore.text = "your score is $correctAns out of $totalQuestions"

        btnFinish.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))
        }



    }
}