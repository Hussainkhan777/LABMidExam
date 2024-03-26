package com.example.exam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupPage(navController: NavController) {

    val username = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val loginBtnState = remember {
        mutableStateOf(false)
    }

    val myContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        TextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            label = {
                Text("User Name", fontSize = 16.sp)
            },
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(0),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Gray,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text("Email", fontSize = 16.sp)
            },
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(0),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Gray,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = {
                Text("Password", fontSize = 16.sp)
            },
            modifier = Modifier
                .width(300.dp)
                .alpha(0.8f),
            shape = RoundedCornerShape(0),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Gray,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.LightGray
            )

        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                if (
                    email.value.isNotEmpty() &&
                    password.value.isNotEmpty() &&
                    username.value.isNotEmpty()
                ) {
                    navController.navigate("login")
                }
            },
            modifier = Modifier
                .width(300.dp)
                .height(55.dp),
            shape = RoundedCornerShape(0),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.White
            )
        ) {

            Text("Register", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(40.dp))

        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                )
            ) {
                append("Already registered!  ")
            }

            pushStringAnnotation(
                tag = "signup",
                annotation = "signup"
            )
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Login Me")
            }
            pop()
            append(".")
        }

        ClickableText(
            text = text,
            onClick = { offset ->
                text.getStringAnnotations(
                    tag = "signup",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    // Handle click on "Sign Up"
                    navController.navigate("login")
                }
            }
        )



    }
}