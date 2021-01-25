package com.example.moulinapplication.dao
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class JokeDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: RoomDB
    private lateinit var dao: JokeDao
    private lateinit var joke: Joke

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RoomDB::class.java
        ).allowMainThreadQueries().build()

        dao = database.JokeDAO

        joke = Joke(123, "Corona", "What's your favorite pandemic", "general", 2.5F)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertJoke() {
        runBlocking {
            dao.instertJoke(joke)
            val alljokes = dao.getAllJokes().getOrAwaitValue()
            Assert.assertTrue(alljokes.contains(joke))
        }
    }

    @Test
    fun deleteJoke() {
        runBlocking {
            dao.deleteJoke(joke)
            val alljokes = dao.getAllJokes().getOrAwaitValue()
            Assert.assertFalse(alljokes.contains(joke))
        }
    }

    @Test
    fun updateJoke() {
        runBlocking {
            dao.instertJoke(joke)
            joke.numberOfStars = 2F
            dao.updateJoke(joke)
            val jokefromdb = dao.getJokeByid(123).getOrAwaitValue()
            Assert.assertEquals(2F, jokefromdb.numberOfStars)
        }
    }
}
