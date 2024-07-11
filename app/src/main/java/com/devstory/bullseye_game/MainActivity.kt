package com.devstory.bullseye_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devstory.bullseye_game.screens.AboutScreen
import com.devstory.bullseye_game.screens.GameScreen
import com.devstory.bullseye_game.ui.theme.BullseyeGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BullseyeGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, "game screen") {
        composable("game screen") { GameScreen(
            onNavigationToAbout = {navController.navigate("about")}
        ) }
        composable("about") { AboutScreen( onNavigateBack = {navController.navigateUp()}) }
    }
}