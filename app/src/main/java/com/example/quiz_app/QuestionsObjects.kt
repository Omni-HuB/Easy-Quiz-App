package com.example.quiz_app

object QuestionsObjects {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String  = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Questions>{
         val questionsList = ArrayList<Questions>()

         val que1  = Questions(
             1, "Which country does this flag belong to ? ",
              R.drawable.ic_flag_of_argentina,
             "Argentina",
             "Brazil",
             "India",
             "Austria",
             1
        )
        questionsList.add(que1)


        val que2  = Questions(
            2, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "India",
            "Austria",
            2
        )
        questionsList.add(que2)


        val que3  = Questions(
            3, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Belgium",
            "India",
            "Austria",
            2
        )
        questionsList.add(que3)


        val que4  = Questions(
            4, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Brazil",
            "India",
            "Austria",
            2
        )
        questionsList.add(que4)


        val que5 = Questions(
            5, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Brazil",
            "India",
            "Denmark",
            4
        )
        questionsList.add(que5)


        val que6  = Questions(
            6, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Brazil",
            "Fiji",
            "Austria",
            3
        )
        questionsList.add(que6)


        val que7  = Questions(
            7, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Brazil",
            "India",
            "Austria",
            1
        )
        questionsList.add(que7)


        val que8  = Questions(
            8, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Brazil",
            "India",
            "Austria",
            3
        )
        questionsList.add(que8)


        val que9  = Questions(
            9, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "Brazil",
            "Kuwait",
            "Austria",
            3
        )
        questionsList.add(que9)


        val que10  = Questions(
            10, "Which country does this flag belong to ? ",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "Brazil",
            "India",
            "New Zealand",
            4
        )
        questionsList.add(que10)


        return questionsList

    }
}