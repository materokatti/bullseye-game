package com.devstory.bullseye_game.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.devstory.bullseye_game.R

@Composable
fun GamePrompt (targetValue: Int,modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            stringResource(R.string.instruction_text),
            style = MaterialTheme.typography.subtitle1.copy(letterSpacing = 1.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = stringResource(id = R.string.target_value_text, targetValue),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun GamePromptPreview() {
    GamePrompt(targetValue = 50)
}
