package com.example.bmicalculator

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bmicalculator.ui.theme.interBold
import com.example.bmicalculator.ui.theme.interMedium
import com.example.bmicalculator.ui.theme.interRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(navController: NavController) {
    var ageNumber by remember {
        mutableStateOf(18)
    }

    var weightNumber by remember {
        mutableStateOf(68)
    }

    var heightAmount by remember {
        mutableStateOf(50f)
    }

    var genereSection by remember {
        mutableStateOf(false)
    }

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

            AgeWeightSection(
                onAgeChanged = { value -> ageNumber = value },
                onWeightChanged = { value -> weightNumber = value },
            )

            Spacer(modifier = Modifier.height(23.dp))

            HeightSection(
                onHeightChanged = { value ->
                    heightAmount = value
                },
            )

            Spacer(modifier = Modifier.height(23.dp))

            GenderSection(
                onGenderChnage = { value ->
                    genereSection = value
                },
            )

            Spacer(modifier = Modifier.height(30.dp))

            ElevatedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff6C63FF)
                ),
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate("ResultScreen")
                }) {
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
private fun AgeWeightSection(
    onAgeChanged: (Int) -> Unit,
    onWeightChanged: (Int) -> Unit,
) {
    var ageNumber by remember {
        mutableStateOf(18)
    }

    var weightAmount by remember {
        mutableStateOf(68)
    }
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
                    text = ageNumber.toString(),
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
                        onClick = {
                            if (ageNumber >= 1) {
                                ageNumber--
                                onAgeChanged(ageNumber)
                            }
                        }) {
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
                        onClick = {
                            if (ageNumber <= 110) {
                                ageNumber++
                                onAgeChanged(ageNumber)
                            }
                        }) {
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
                    text = weightAmount.toString(),
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
                        onClick = {
                            if (weightAmount >= 30) {
                                weightAmount--
                                onWeightChanged(weightAmount)
                            }
                        }) {
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
                        onClick = {
                            weightAmount++
                            onWeightChanged(weightAmount)
                        }) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HeightSection(onHeightChanged: (Float) -> Unit) {
    var heightMetrick by remember {
        mutableStateOf(50f)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
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

            Slider(
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xff6C63FF),
                    activeTrackColor = Color(0xffCCCCCC),
                    inactiveTrackColor = Color(0xffCCCCCC),
                ),
                valueRange = 50f..300f,
                value = heightMetrick, onValueChange = { value ->
                    heightMetrick = value
                    onHeightChanged(heightMetrick)
                },
                thumb = {
                    val interactionSource = remember {
                        MutableInteractionSource()
                    }
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        thumbSize = DpSize(27.dp, 27.dp),
                    )
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "50 cm",
                    style = TextStyle(
                        fontFamily = interRegular, fontSize = 13.sp, color = Color(0xff081854),
                    ),
                )
                Text(
                    "300cm",
                    style = TextStyle(
                        fontFamily = interRegular, fontSize = 13.sp, color = Color(0xff081854),
                    ),
                )

            }
        }
    }
}


@Composable
private fun GenderSection(onGenderChnage: (Boolean) -> Unit) {

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
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "Gender",
                style = TextStyle(
                    fontFamily = interRegular, fontSize = 17.sp, color = Color(0xff081854),
                ),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    "Male",
                    style = TextStyle(
                        fontFamily = interRegular,
                        fontSize = 17.sp,
                        color = Color(0xff081854),
                    ),
                )
                Spacer(modifier = Modifier.width(40.dp))

                Switch2(
                    onGenderChnage = { onGenderChnage(it) }
                )

                Spacer(modifier = Modifier.width(32.dp))
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


@Composable
fun Switch2(
    scale: Float = 2f,
    width: Dp = 55.dp,
    height: Dp = 20.dp,
    checkedTrackColor: Color = Color(0xffF4F3FF),
    uncheckedTrackColor: Color = Color(0xffF4F3FF),
    gapBetweenThumbAndTrackEdge: Dp = 4.dp,
    onGenderChnage: (Boolean) -> Unit,
) {

    var isMale by remember {
        mutableStateOf(true) // Initially the switch is ON
    }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    // To move thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (isMale)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        isMale = !isMale
                        onGenderChnage(isMale)
                    }
                )
            }
    ) {
        // Track
        drawRoundRect(
            color = if (isMale) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),

            )

        // Thumb
        drawCircle(
            color = Color(0xff6C63FF),
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }
}