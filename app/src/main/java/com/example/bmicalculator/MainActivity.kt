package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICalculatorTheme {
                AppNavigation()
            }
        }
    }
}


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "IntroScreen"){
        composable(route = "IntroScreen"){
            IntroScreenContent(navController)
        }

        composable(route = "HomeScreen"){
            HomeScreenContent(navController)
        }

        composable(route = "ResultScreen/{bmiValue}/{maleGender}", arguments = listOf(
            navArgument(name = "bmiValue") {type = NavType.FloatType},
            navArgument(name = "maleGender"){type = NavType.BoolType}
        )){
            stackEntry ->
            val bmiValue = stackEntry.arguments?.getFloat("bmiValue")
            val maleGender = stackEntry.arguments?.getBoolean("maleGender")
            ResultScreenContent(navController, bmiValue = bmiValue!! , maleGender = maleGender!!)
        }

    }
}