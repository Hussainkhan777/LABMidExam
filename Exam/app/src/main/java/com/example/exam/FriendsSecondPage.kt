package com.example.exam

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendsSecondPage(navController: NavController, id: Int) {
    val tint = Color(0xFF00FF00) //

    val actorsList = RetrieveActorsData()
    val selectedActor = actorsList[id]

    val rating = remember {
        mutableIntStateOf(0)
    }

    val star = remember {
        mutableStateOf(R.drawable.empty_star)
    }

    val stars: Int = 5

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Details Activity")
                },
                navigationIcon = {
                    // Back button
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                },
                actions = {
                    Icon(Icons.Default.MoreVert, contentDescription = "Arrow Back")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it)

            ) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(0.dp, 20.dp, 0.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    for( i in 1..stars) {

                        if (i <= rating.intValue) {
                            star.value = R.drawable.filled_star
                        }
                        else {
                            star.value = R.drawable.empty_star
                        }
                        Icon(
                            painter = painterResource(id = star.value),
                            contentDescription = null,
                            tint = tint,
                            modifier = Modifier
                                .padding(2.5.dp)
                                .size(50.dp)
                                .clickable {
                                    rating.intValue = i
                                    Toast.makeText(
                                        navController.context,
                                        "You have Rated: ${rating.intValue} star",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    print("Hello World")
                                }
                        )


                    }
                }

                Image(
                    painter = painterResource(id = selectedActor.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp, 0.dp)
                        .fillMaxWidth()
                        .height(400.dp)
                )

                Text(
                    text = selectedActor.details,
                    modifier = Modifier
                        .padding(20.dp, 0.dp, 20.dp, 20.dp)
                        .verticalScroll(rememberScrollState())
                )
            }
        }
    )
}