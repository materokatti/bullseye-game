package com.devstory.bullseye_game

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource


@Composable
fun ResultDialog(
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {}
            ) {
                Text(stringResource(id = R.string.result_dialog_button_text))
            }
        },
        title = { Text(stringResource(id = R.string.result_dialog_title)) },
        text = { Text(stringResource(id = R.string.result_dialog_message)) }
    )
}