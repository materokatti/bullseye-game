package com.devstory.bullseye_game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
        Text("PUT THE BULLSEYE AS YOU CAN TO")
        Text(text = "89", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Row {
            Text(text = "1")
            Slider(
                value = 0.5f,
                valueRange = 0.01f..1f,
                onValueChange = {}
            )
            Text(text = "100")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "HIT ME")
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