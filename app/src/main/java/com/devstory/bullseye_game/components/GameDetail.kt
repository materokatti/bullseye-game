package com.devstory.bullseye_game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devstory.bullseye_game.R

@Composable
fun GameDetail (
    modifier: Modifier = Modifier,
    totalScore: Int = 0,
    currentRound: Int = 1,
    onStartOver: () -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        IconButton(
            onClick = { onStartOver() },
            modifier = Modifier
                .background(color = Color.Black, shape = CircleShape) // 채워진 배경 적용
                .size(48.dp) // 버튼 크기 조정
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh",
                tint = Color.White
            )
        }
        GameInfo(label = stringResource(id = R.string.score_label), value = totalScore)
        GameInfo(label = stringResource(id = R.string.current_round_label), value = currentRound)
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
        Text(
            value.toString(),
            style = MaterialTheme.typography.body1.copy(fontSize = 20.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailPreview() {
    GameDetail(onStartOver = {})
}