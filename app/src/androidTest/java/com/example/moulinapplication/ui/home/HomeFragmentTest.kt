package com.example.moulinapplication.ui.home

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.moulinapplication.MainActivity
import com.example.moulinapplication.R
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeFragmentTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private fun jokeIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.joke_setup)).check(
            matches(
                ViewMatchers.isDisplayed()
            )
        )

    }

    private fun whenPressPunchIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.punchbutton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.punchlinetext)).check((matches((isDisplayed()))));

    }

    private fun getNewJoke() {
        Espresso.onView(ViewMatchers.withId(R.id.jokebutton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.joke_setup)).check(
            matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    private fun addToFavouritesWithoutPunch_NotDisplay() {
        Espresso.onView(ViewMatchers.withId(R.id.addbutton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.punchlinetext)).check(
            matches(
                not(ViewMatchers.isDisplayed())
            )
        )
    }

    private fun addToFavouritesWithPunch_Display_navToAddJokeFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.jokebutton)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.addbutton)).perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.homefragment)).check(
            matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun fullFragmentTest() {
        jokeIsVisible()
        whenPressPunchIsVisible()
        getNewJoke()
        addToFavouritesWithoutPunch_NotDisplay()
        addToFavouritesWithPunch_Display_navToAddJokeFragment()

    }


}
