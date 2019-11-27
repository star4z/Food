package com.philllipsb.food

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ideas.*
import kotlin.random.Random

class IdeasActivity : AppCompatActivity(), MealFilesUtils {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ideas)

        val random = Random(System.currentTimeMillis())
        val meals = getMeals(this)
        if (meals.isNotEmpty()) {
            val meal = meals[random.nextInt(meals.size)]
            val textView = TextView(this)
            textView.text = meal.name
            list_ideas.addView(textView)
        } else {
            val toastLength = Toast.LENGTH_LONG
            val message = "All out of ideas. Add more, please uwu"
            Toast.makeText(this, message, toastLength).show()
        }
    }
}
