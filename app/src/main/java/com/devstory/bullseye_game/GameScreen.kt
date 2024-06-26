package com.devstory.bullseye_game

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devstory.bullseye_game.ui.theme.BullseyeGameTheme

@Composable
fun GameScreen() {
    var alertIsVisible : Boolean by rememberSaveable {mutableStateOf(false)}
    var sliderValue by rememberSaveable {mutableStateOf(0.5f)}
    val sliderToInt = (sliderValue * 100).toInt()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            GamePrompt()
            TargetSlider(
                value = sliderValue,
                valueChanged = { value ->
                    sliderValue = value
                }
            )
            Button(onClick = {
                alertIsVisible = true
                Log.i("Alert Visible? :", alertIsVisible.toString())
            }) {
                Text(text = stringResource(R.string.hit_me_button_text))
            }
        }
        Spacer(modifier = Modifier.weight(.5f))

        if (alertIsVisible) {
            ResultDialog(
                hideDialog = {alertIsVisible = false},
                sliderValue = sliderToInt
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BullseyeGameTheme {
        GameScreen()
    }
}