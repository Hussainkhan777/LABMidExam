package com.example.exam

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@ExperimentalMaterial3Api
@Composable
fun MakeCallAndBrowseApp() {
    var inputText by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("Make Call") }

    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text field for entering phone number or URL
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter Phone Number or URL") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.padding(16.dp)
        )

        // Radio buttons to choose between making a call and browsing URL
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(
                selected = selectedOption == "Make Call",
                onClick = { selectedOption = "Make Call" },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Make Call")

            RadioButton(
                selected = selectedOption == "Browse URL",
                onClick = { selectedOption = "Browse URL" },
                modifier = Modifier.padding(start = 16.dp)
            )
            Text("Browse URL")
        }

        // Button to perform action based on user selection
        Button(
            onClick = {
                if (inputText.isNotEmpty()) {
                    if (selectedOption == "Make Call") {
                        makePhoneCall(context, activity, inputText)
                    } else {
                        browseURL(context, inputText)
                    }
                } else {
                    Toast.makeText(context, "Please enter a phone number or URL", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(selectedOption)
        }
    }
}
// The browseURL function is necessary for MakeCallAndBrowseApp
private fun browseURL(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

// The makePhoneCall function with three parameters is necessary for MakeCallAndBrowseApp
fun makePhoneCall(context: Context, activity: Activity, phoneNumber: String) {
    if (ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")
        activity.startActivity(intent)
    } else {
        // Request permission
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(android.Manifest.permission.CALL_PHONE),
            REQUEST_CALL_PHONE_PERMISSION
        )
    }
}
