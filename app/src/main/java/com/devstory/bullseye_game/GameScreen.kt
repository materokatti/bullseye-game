package com.devstory.bullseye_game

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devstory.bullseye_game.ui.theme.BullseyeGameTheme

@Composable
fun GameScreen() {
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
            Text("PUT THE BULLSEYE AS YOU CAN TO")
            Text(text = "89", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Slider(
                    value = 0.5f,
                    valueRange = 0.01f..1f,
                    onValueChange = {},
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "100",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "HIT ME")
            }
        }
        Spacer(modifier = Modifier.weight(.5f))
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BullseyeGameTheme {
        GameScreen()
    }
}