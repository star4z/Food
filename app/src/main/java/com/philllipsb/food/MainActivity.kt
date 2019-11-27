package com.philllipsb.food

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()

    }

    private fun setUpListeners() {
        btn_create_plan.setOnClickListener {
            startActivity(Intent(this, PlanActivity::class.java))
        }
        btn_add_meal.setOnClickListener {
            startActivity(Intent(this, MealActivity::class.java))
        }
        btn_generate_idea.setOnClickListener {
            startActivity(Intent(this, IdeasActivity::class.java))
        }
    }
}
