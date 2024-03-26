package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.exam.ui.theme.ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamTheme {
//              stateManagement()
//                MainScreen()
//                Prac_Screen()
//                CameraPermission()
//                MakeCallAndBrowseApp()
//                MyComposabIeFunction()
//                LogInSignUpNavigation()
//                ActorsNavigation()

            }
        }
    }

    /*This below Code is only for make call and browse app functionality


    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL_PHONE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the call
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            } else {
                // Permission denied, show a message or handle it accordingly
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
    */
}

const val REQUEST_CALL_PHONE_PERMISSION = 123

/*
@Composable
fun LogInSignUpNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(navController)
        }
        composable("signup") {
            SignupPage(navController)
        }
    }
}
*/

/*
@Composable
fun ActorsNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "actorslist") {
        composable("actorslist") {
            FriendsrFrontPage(navController)
        }
        composable(
            route = "actordetails/{actorId}",
            arguments = listOf(
                navArgument("actorId") {
                    type = androidx.navigation.NavType.IntType
                }
            )
        ) { backStackEntry ->
            val actorId = backStackEntry.arguments?.getInt("actorId")

            actorId?.let{
                FriendsSecondPage(navController, actorId)
            }
        }
    }
}
*/
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExamTheme {
//        stateManagement()
//        MainScreen()
//        Prac_Screen()
//        CameraPermission()
//        MakeCallAndBrowseApp()
//        MyComposabIeFunction()
//        LogInSignUpNavigation()
//        ActorsNavigation()
    }
}