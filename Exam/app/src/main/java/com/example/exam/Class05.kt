package com.example.exam

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A composable function that manages the state of multiple counters.
 *
 * This function creates a column layout with three counters: a water counter, a food counter, and a juice counter.
 * Each counter is initialized with a value of 0 using the rememberSaveable() function, which allows the state to be saved across recompositions.
 * The state of each counter is managed by the StateLessCount() function, which increments the counter value when its button is clicked.
 */
@Composable
fun stateManagement() {

    // Create a column layout with centered alignment
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Initialize the water counter with a value of 0
        val waterCount = rememberSaveable() {
            mutableIntStateOf(0)
        }

        // Create a counter for water
        StateLessCount(
            count = waterCount.value,
            IncCounter = { waterCount.value++ },
            name = "Water Counter"
        )

        // Initialize the food counter with a value of 0
        val foodCount = rememberSaveable() {
            mutableIntStateOf(0)
        }

        // Create a counter for food
        StateLessCount(
            count = foodCount.value,
            IncCounter = { foodCount.value++ },
            name = "Food Counter"
        )

        // Initialize the juice counter with a value of 0
        val juiceCount = rememberSaveable() {
            mutableIntStateOf(0)
        }

        // Create a counter for juice
        StateLessCount(
            count = juiceCount.value,
            IncCounter = { juiceCount.value++ },
            name = "Juice Counter"
        )
    }
}

/**
 * A composable function that displays a counter with an increment button.
 *
 * @param count The current count to be displayed.
 * @param IncCounter A function to be called when the increment button is clicked.
 * @param name The name of the counter, to be displayed next to the count.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun StateLessCount(
    count: Int,
    IncCounter: () -> Unit,
    name: String,
    modifier: Modifier = Modifier
) {

    // Display the name and count
    Text(text = "${name} : $count", fontSize = 30.sp)

    // Add some space
    Spacer(modifier = Modifier.height(8.dp))

    // Get the current context
    val myContext = LocalContext.current

    // Create an intent for TestActivity
    //  val intent: Intent = Intent(myContext, TestActivity::class.java)

    // Add an extra to the intent
//    intent.putExtra("name", "Bilawal")

    val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    // Create a button that increments the count and starts the activity when clicked
    Button(onClick = {
        IncCounter()
        myContext.startActivity(intent)
    }) {
        Text(text = "Increment")
    }

    // Add some more space
    Spacer(modifier = Modifier.height(16.dp))
}