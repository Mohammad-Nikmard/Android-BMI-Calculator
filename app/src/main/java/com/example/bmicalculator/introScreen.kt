package com.example.bmicalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmicalculator.ui.theme.interBold
import com.example.bmicalculator.ui.theme.interExtraBoldItalic
import com.example.bmicalculator.ui.theme.interMedium
import com.example.bmicalculator.ui.theme.interRegular


@Composable
fun IntroScreenContent(navController: NavController) {
    Scaffold(containerColor = Color(0xff6C63FF)) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 40.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                "BMiDO",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = interExtraBoldItalic,
                    textAlign = TextAlign.Center,
                ),
            )

            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.bmi_vector),
                contentDescription = "BMI Vector",
            )

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                "Get Started With Tracking Your Health!",
                modifier = Modifier.padding(end = 10.dp),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 25.sp,
                    fontFamily = interBold,
                    textAlign = TextAlign.Start,
                ),
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                "Calculate your BMI and stay on top of your wellness journey, effortlessly!",
                style = TextStyle(
                    fontSize = 15.sp, color = Color(0xffC6C3F9), fontFamily = interRegular,
                ),
            )

            Spacer(modifier = Modifier.height(35.dp))

            ElevatedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xff081854)
                ),
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate("HomeScreen")
                }) {
                Text(
                    "Get Started",
                    style = TextStyle(
                        fontFamily = interMedium,
                        fontSize = 17.sp,
                        color = Color(0xff081854),
                    ),
                )
            }

        }
    }
}