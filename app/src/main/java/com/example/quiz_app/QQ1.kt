package com.example.quiz_app

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QQ1 : AppCompatActivity(), View.OnClickListener {

    private var mUserName : String? = null


    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOption: Int = 0


    private var mCorrectAns : Int = 0


    private var queScreen_que_tv: TextView? = null
    private var queScreen_progressbar: ProgressBar? = null
    private var queScreen_progressbar_tv: TextView? = null
    private var queScreen_iv: ImageView? = null


    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null

    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qq1)


        mUserName = intent.getStringExtra(QuestionsObjects.USER_NAME)


        queScreen_iv = findViewById(R.id.queScreen_iv)
        queScreen_progressbar = findViewById(R.id.queScreen_progressbar)
        queScreen_que_tv = findViewById(R.id.queScreen_que_tv)
        queScreen_progressbar_tv = findViewById(R.id.queScreen_progressbar_tv)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        btnSubmit = findViewById(R.id.btnSubmit)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = QuestionsObjects.getQuestions()

        setQuestion()




    }


    private fun setQuestion() {

        val question: Questions = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

//        Log.i("QuestionsList Size : ", "${questionList.size}")
//
//        for (i in questionList) {
//            Log.e("Questions", i.question)

       // mCurrentPosition = 1

        queScreen_progressbar?.progress = mCurrentPosition

        queScreen_progressbar_tv?.text = "$mCurrentPosition" + "/" + "${queScreen_progressbar?.max}"

        queScreen_iv?.setImageResource(question.image)
        queScreen_que_tv?.text = question.question
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }
    }



    private fun defaultOptionsView(){

        val options  =  ArrayList<TextView>()

        option1?.let{
            options.add(0, it)
        }
        option2?.let{
            options.add(1, it)
        }
        option3?.let{
            options.add(2, it)
        }
        option4?.let{
            options.add(3,it)
        }

        for (option in options){
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface = Typeface.DEFAULT
             option.background = ContextCompat.getDrawable(this,
                 R.drawable.default_option
                //R.drawable.selected_option
             )

        }


    }

    private fun selectedOption(tv : TextView, selectedOptionNum : Int){

        defaultOptionsView()

        mSelectedOption  = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
           // R.drawable.default_option
            R.drawable.selected_option
        )
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1->{
                option1?.let{
                    selectedOption(it,1)
                }
            }
            R.id.option2->{
                option2?.let{
                    selectedOption(it,2)
                }
            }
            R.id.option3->{
                option3?.let{
                    selectedOption(it,3)
                }
            }
            R.id.option4->{
                option4?.let{
                    selectedOption(it,4)
                }
            }


            R.id.btnSubmit->{
                if(mSelectedOption == 0) {
                    mCurrentPosition+=1

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
//                            Toast.makeText(this, "you made it to the end ", Toast.LENGTH_SHORT)
//                                .show()
                            var intent = Intent(this, ResultActivity::class.java)

                            intent.putExtra(QuestionsObjects.USER_NAME, mUserName)
                            intent.putExtra(QuestionsObjects.CORRECT_ANSWERS, mCorrectAns)
                            intent.putExtra(QuestionsObjects.TOTAL_QUESTIONS, mQuestionsList?.size )
                            startActivity(intent)
                            finish()


                        }
                    }
                }else{

                    var question = mQuestionsList?.get(mCurrentPosition -1)

                    if(question!!.correctAns != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_answer)
                    }
//                    else{
//                        mCorrectAns++
//                    }

                    answerView(question.correctAns, R.drawable.correct_answer)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }
                    else{
                        btnSubmit?.text = "NEXT"
                    }
                    mSelectedOption = 0


                    }
                }

        }


    }


    private fun answerView(answer: Int, drawableView: Int ){

        when(answer){
            1->{
                option1?.background = ContextCompat.getDrawable(
                    this@QQ1,
                    drawableView)
            }
            2->{
                option1?.background = ContextCompat.getDrawable(
                    this@QQ1,
                    drawableView)
            }
            3->{
                option1?.background = ContextCompat.getDrawable(
                    this@QQ1,
                    drawableView)
            }
            4->{
                option1?.background = ContextCompat.getDrawable(
                    this@QQ1,
                    drawableView)
            }
        }
    }


}
