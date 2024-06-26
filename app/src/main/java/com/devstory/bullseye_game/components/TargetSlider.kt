package com.devstory.bullseye_game.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devstory.bullseye_game.R

@Composable
fun TargetSlider(
    modifier: Modifier = Modifier,
    value:Float = 0.5f,
    valueChanged: (Float) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            stringResource(id = R.string.min_value_text),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 16.dp)
        )
        Slider(
            value = value,
            valueRange = 0.01f..1f,
            onValueChange = valueChanged,
            modifier = Modifier.weight(1f)
        )
        Text(
            stringResource(id = R.string.max_value_text),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}
