package com.example.bmicalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.interBold
import com.example.bmicalculator.ui.theme.interMedium
import com.example.bmicalculator.ui.theme.interRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreenContent() {
    Scaffold(
        containerColor = Color(0xfff4f3ff),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "BMI CALCULATOR",
                        style = TextStyle(
                            fontSize = 17.sp, fontFamily = interRegular,
                        ),
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color(0xff081854),
                ),

                )
        },
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                "BODY MASS INDEX",
                style = TextStyle(
                    fontFamily = interRegular,
                    color = Color(0xff081854),
                    fontSize = 27.sp,
                    textAlign = TextAlign.Center,
                ),
            )
            Spacer(modifier = Modifier.height(40.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(416.dp),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Spacer(modifier = Modifier.height(40.dp))


                    Text(
                        "BMI Results", style = TextStyle(
                            fontSize = 32.sp, fontFamily = interRegular, color = Color(0xff081854),
                            textAlign = TextAlign.Center,
                        )
                    )

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            "22",
                            style = TextStyle(
                                fontFamily = interBold,
                                fontSize = 140.sp,
                                color = Color(0xff6C63FF),
                            ),
                        )
                        Text(
                            ".54",
                            modifier = Modifier.padding(bottom = 25.dp),
                            style = TextStyle(
                                fontFamily = interMedium,
                                fontSize = 42.sp,
                                color = Color(0xff6C63FF),
                            ),
                        )
                    }

                    Text(
                        "NORMAL BMI",
                        style = TextStyle(
                            fontSize = 24.sp, fontFamily = interMedium, color = Color(0xff081854),
                        ),
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        "Underweight: BMI less that 18.5 Normal weight: BMI 18.5 to 24.9 Overweight: BMI 25 to 29.9 Obesity: 30 to 40",
                        modifier = Modifier.padding(horizontal = 60.dp),
                        style = TextStyle(
                            fontSize = 13.sp, color = Color(0xff081854), fontFamily = interMedium,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            ElevatedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff6C63FF),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp),
                onClick = {}) {
                Text(
                    "Calculate Again", style = TextStyle(
                        fontSize = 17.sp, color = Color.White, fontFamily = interMedium,
                    )
                )
            }

        }
    }
}