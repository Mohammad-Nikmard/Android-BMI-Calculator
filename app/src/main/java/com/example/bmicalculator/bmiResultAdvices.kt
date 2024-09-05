package com.example.bmicalculator

import androidx.compose.runtime.Composable

@Composable
public fun bmiResultText (isMale : Boolean, bmiResult : Float) : String {
    if(bmiResult <= 18.5){
        return if(isMale){
            "UnderWeight: Focus on nutrient-dense foods to increase your caloric intake and build muscle mass. Strength training can help you gain healthy weight."
        }else{
            "UnderWeight: Consider incorporating more balanced meals with healthy fats, proteins, and complex carbs. Weight-bearing exercises can enhance muscle tone and overall health."
        }
    }else if(bmiResult > 18.5 && bmiResult <= 24.9){
        return if(isMale){
            "Normal: Maintain your weight by continuing regular exercise and balanced nutrition. Focus on both cardiovascular health and strength training."
        }else{
            "Normal : Keep up a varied diet with plenty of fruits, vegetables, and lean proteins. Regular physical activity, including yoga or pilates, can help maintain muscle tone and flexibility."
        }
    }else if(bmiResult > 24.9 && bmiResult <= 29.9){
        return if(isMale){
            "OverWeight: Incorporate more cardiovascular exercises, like running or cycling, into your routine. Pay attention to portion sizes and choose whole foods over processed options."
        }else{
            "OverWeight: Gradually increase physical activity, focusing on both cardio and strength training. Consider a balanced diet with smaller, frequent meals to support weight management."
        }
    }else{
        return if(isMale){
            "Obesity: A combination of regular exercise and a diet rich in vegetables, lean proteins, and whole grains can help you lose weight. Consult a healthcare provider for personalized advice."
        }else{
            "Obesity: Focus on gradual lifestyle changes, such as swapping sugary snacks for healthier options and incorporating daily movement. Professional support can be beneficial in creating a sustainable weight loss plan."
        }
    }
}