package com.example.moulinapplication.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class JokeTest {

    lateinit var joke: Joke

    @Before
    fun setUp() {
        joke = Joke(123, "Corona", "What's your favorite pandemic", "general", 2.5F)
    }

    @Test
    fun getPunchline() {
        Assert.assertEquals("Corona", joke.punchline)
    }

    @Test
    fun setPunchline() {
        joke.punchline = "iets anders"
        Assert.assertEquals("iets anders", joke.punchline)
    }

    @Test
    fun getSetup() {
        Assert.assertEquals("What's your favorite pandemic", joke.setup)
    }

    @Test
    fun setSetup() {
        joke.setup = "iets anders"
        Assert.assertEquals("iets anders", joke.setup)
    }

    @Test
    fun getType() {
        Assert.assertEquals("general", joke.type)
    }
}
