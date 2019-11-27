package com.philllipsb.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_meal.*

class MealActivity : AppCompatActivity(), MealFilesUtils {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        addListeners()
    }

    private fun addListeners() {
        btn_save_meal.setOnClickListener {
            addMeal(this, Meal(edit_meal_title.text.toString()))
            finish()
        }
    }
}
