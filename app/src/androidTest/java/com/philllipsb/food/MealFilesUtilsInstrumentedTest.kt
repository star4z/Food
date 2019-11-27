package com.philllipsb.food

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MealFilesUtilsInstrumentedTest {
    @Test
    fun testRead() {

    }

    @Test
    fun testWrite() {
        val meal = Meal("Test")
        val util = object:MealFilesUtils {}
        val context = InstrumentationRegistry.getInstrumentation().context
        util.addMeal(context, meal)
    }
}