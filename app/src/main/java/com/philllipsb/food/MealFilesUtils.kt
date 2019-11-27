package com.philllipsb.food

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileNotFoundException

interface MealFilesUtils {
    fun getFileName() = "meals.json"

    fun getMeals(context: Context): ArrayList<Meal> {
        val s = getRawData(context)
        return if (s.isEmpty()) {
            ArrayList()
        } else {
            val gson = Gson()
            val type = object : TypeToken<ArrayList<Meal>>() {}.type
            gson.fromJson(s, type)
        }
    }

    private fun getRawData(context: Context): String {
        val fileName = getFileName()
        return try {
            context.openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
        } catch (e: FileNotFoundException) {
            File(context.filesDir,  fileName).createNewFile()
            ""
        }
    }

    fun addMeal(context: Context, meal: Meal) {
        val meals = getMeals(context)
        meals.add(meal)

        val gson = Gson()
        val s = gson.toJson(meals)

        context.openFileOutput(getFileName(), Context.MODE_PRIVATE).use {
            it.write(s.toByteArray())
        }
    }
}