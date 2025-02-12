package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class BMIViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val height : Float
        get(){
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    private val weight : Int
        get(){
            return weightInput.toIntOrNull() ?: 0
        }
    val bmi : String
        get(){
            return if (weight > 0 && height > 0) {
                val bmiValue = weight / (height * height)
                DecimalFormat("0.00").format(bmiValue) // Format to 2 decimal places
            } else {
                "0.00" // Default value
            }
        }
}