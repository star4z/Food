package com.philllipsb.food

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_plan.*
import kotlin.random.Random

class PlanActivity : AppCompatActivity(), MealFilesUtils {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        val meals = getMeals(this)
        val weekDays = arrayListOf(
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        )
        if (meals.size >= weekDays.size) {
            val random = Random(System.currentTimeMillis())

            val usedIndices = HashSet<Int>()
            for (weekDay in weekDays) {
                val weekDayTextView = TextView(this)
                weekDayTextView.text = weekDay
                list_plan.addView(weekDayTextView)

                println(weekDay)

                var i = random.nextInt(meals.size)
                println(i)
                while (i in usedIndices) {
                    i++
                    if (i == meals.size) {
                        i = 0
                    }
                    println(i)
                }
                usedIndices.add(i)
                val mealIdeaTextView = TextView(this)
                mealIdeaTextView.text = meals[i].name
                list_plan.addView(mealIdeaTextView)
            }
        } else {
            val message =
                "I need at least ${weekDays.size} meal ideas to make a plan. Currently, you have ${meals.size}."
            val toastLength = Toast.LENGTH_LONG
            Toast.makeText(this, message, toastLength).show()
        }
    }
}
