package com.example.bmicalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.interBold
import com.example.bmicalculator.ui.theme.interMedium
import com.example.bmicalculator.ui.theme.interRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent() {
    Scaffold(
        containerColor = Color(0xfff4f5ff),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    Text(
                        "BMI CALCULATOR",
                        style = TextStyle(
                            fontSize = 17.sp, fontFamily = interRegular, color = Color(0xff081854),
                        ),
                    )
                })
        },
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 30.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            AgeWeightSection()

            Spacer(modifier = Modifier.height(23.dp))

            HeightSection()

            Spacer(modifier = Modifier.height(23.dp))

            GenderSection()

            Spacer(modifier = Modifier.height(30.dp))

            ElevatedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff6C63FF)
                ),
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth(),
                onClick = {}) {
                Text(
                    text = "Calculate BMI",
                    style = TextStyle(
                        color = Color.White, fontSize = 17.sp, fontFamily = interMedium,
                    ),
                )
            }

        }
    }
}

@Composable
private fun AgeWeightSection() {
    Row {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .weight(1f)
                .height(175.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(27.dp))

                Text(
                    text = "Age",
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color(0xff2F2E41),
                        fontFamily = interRegular,
                    ),
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "30",
                    style = TextStyle(
                        fontSize = 57.sp,
                        color = Color(0xff6C63FF),
                        fontFamily = interBold,
                    ),
                )

                Row {
                    IconButton(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xff081854)
                        ),
                        onClick = {}) {
                        Image(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.icon_minus),
                            contentDescription = "Negative"
                        )
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    IconButton(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xff081854)
                        ),
                        onClick = {}) {
                        Image(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.icon_add),
                            contentDescription = "Add"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .weight(1f)
                .height(175.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(27.dp))

                Text(
                    text = "Weight (KG)",
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color(0xff2F2E41),
                        fontFamily = interRegular,
                    ),
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "78",
                    style = TextStyle(
                        fontSize = 57.sp,
                        color = Color(0xff6C63FF),
                        fontFamily = interBold,
                    ),
                )

                Row {
                    IconButton(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xff081854)
                        ),
                        onClick = {}) {
                        Image(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.icon_minus),
                            contentDescription = "Negative"
                        )
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    IconButton(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xff081854)
                        ),
                        onClick = {}) {
                        Image(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.icon_add),
                            contentDescription = "Add"
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HeightSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(183.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                "Height (CM)",
                style = TextStyle(
                    fontFamily = interRegular, fontSize = 17.sp, color = Color(0xff081854),
                ),
            )
            Text(
                "175",
                style = TextStyle(
                    fontSize = 57.sp, fontFamily = interBold, color = Color(0xff6C63FF),
                ),
            )
        }
    }
}


@Composable
private fun GenderSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "Gender",
                style = TextStyle(
                    fontFamily = interRegular, fontSize = 17.sp, color = Color(0xff081854),
                ),
            )

            Spacer(modifier = Modifier.height(26.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Male",
                    style = TextStyle(
                        fontFamily = interRegular,
                        fontSize = 17.sp,
                        color = Color(0xff081854),
                    ),
                )
                Text(
                    "Female",
                    style = TextStyle(
                        fontFamily = interRegular,
                        fontSize = 17.sp,
                        color = Color(0xff081854),
                    ),
                )
            }

        }
    }
}