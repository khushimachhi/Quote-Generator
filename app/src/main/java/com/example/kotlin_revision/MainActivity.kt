package com.example.kotlin_revision

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kotlin_revision.ui.theme.Kotlin_revisionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_revisionTheme {
                var screen by remember { mutableStateOf("home") }

                when(screen){
                    "home" -> HomeScreen(
                        onNavigationToQuotes = { screen = "quotes"},
                        onNavigationToGenerator = { screen = "generator"}
                    )
                    "quotes" -> Quote(onBack = { screen = "home" })
                    "generator" -> QuoteGenerator(onBack = { screen = "home" })
                }

            }
        }
    }
}


@Composable
fun Name(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
