package com.devstory.bullseye_game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devstory.bullseye_game.R

@Composable
fun GameDetail (modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.start_over))
        }
        GameInfo(label = stringResource(id = R.string.score_label), value = 0)
        GameInfo(label = stringResource(id = R.string.current_round_label), value = 1)
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.info))
        }
    }
}

@Composable
fun GameInfo(label: String, value : Int = 0) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        Text(label)
        Text(value.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailPreview() {
    GameDetail()
}