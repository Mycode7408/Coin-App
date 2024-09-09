package com.mahmood.scogoapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinDetailActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(CoinDetailActivity::class.java)

    @Test
    fun testDisplayCoinDetails() {
        onView(withId(R.id.textCoinName)).check(matches(withText("Bitcoin")))
        onView(withId(R.id.textCoinSymbol)).check(matches(withText("BTC")))
        // Add more checks for other views
    }

    @Test
    fun testHandleNullCoinData() {

    }
}
