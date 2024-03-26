package com.example.exam

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

//    store returned image in bitmap
    val cameraDataReturn = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data
            val imageBitmap = data?.extras?.get("data") as Bitmap
            bitmap.value = imageBitmap
        }
        else{
            Toast.makeText(context, "Image capture cancelled", Toast.LENGTH_SHORT).show()
        }
    }


//    Take permission from user
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    Column {
        Button(onClick = {
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) -> {
                    cameraDataReturn.launch(intent)
                }

                else -> {
                    cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
                }
            }
        }) {
            Text("Open Camera")
        }

        bitmap.value?.let {
            Image(bitmap = it.asImageBitmap(), contentDescription = "Captured Image")
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Prac_Screen(){

    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    val myContext = LocalContext.current

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        if(it){
            Toast.makeText(myContext, "Permission Granted", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(myContext, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Camera App")
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(text = "Bottom Bar")
            }
        },
        content = {
            Column (modifier = Modifier.padding(it)) {

                Button(onClick = {
                    when(PackageManager.PERMISSION_GRANTED){
                        ContextCompat.checkSelfPermission(myContext, android.Manifest.permission.CAMERA) ->
                        {
                            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            myContext.startActivity(intent)
                        }
                        else -> {
                            permissionLauncher.launch(android.Manifest.permission.CAMERA)

                        }
                    }
                }) {
                    Text(text = "get permission")
                }
            }
        }
    )
}