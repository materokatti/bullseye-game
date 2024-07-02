package com.devstory.bullseye_game.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstory.bullseye_game.R
import com.devstory.bullseye_game.components.GameDetail
import com.devstory.bullseye_game.components.GamePrompt
import com.devstory.bullseye_game.components.ResultDialog
import com.devstory.bullseye_game.components.TargetSlider
import com.devstory.bullseye_game.ui.theme.BullseyeGameTheme
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun GameScreen() {
    var alertIsVisible : Boolean by rememberSaveable {mutableStateOf(false)}
    var sliderValue by rememberSaveable {mutableStateOf(0.5f)}
    var targetValue by rememberSaveable {
        mutableStateOf(Random.nextInt(1, 100))
    }

    val sliderToInt = (sliderValue * 100).toInt()

    fun pointsForCurrentRound(): Int {
        val maxScore = 100
        val difference = abs(targetValue - sliderToInt)
        return maxScore - difference
    }


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
            GamePrompt(targetValue = targetValue)
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
            GameDetail(modifier = Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.weight(.5f))

        if (alertIsVisible) {
            ResultDialog(
                hideDialog = {alertIsVisible = false},
                sliderValue = sliderToInt,
                points = pointsForCurrentRound()
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 864, heightDp = 432)
@Composable
fun GameScreenPreview() {
    BullseyeGameTheme {
        GameScreen()
    }
}