package com.example.kotlin_revision

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quote(onBack: () -> Unit) {
    val quotes = listOf(
        "All the world's a stage, and all the men and women merely players." to "William Shakespear",
        "You cannot find peace by avoiding life" to "Virginia Woolf",
        "If You Are Working On Something That You Really Care About, You Don’t Have To Be Pushed. The Vision Pulls You." to "Steve Jobs",
        "The Way Get Started Is To Quit Talking And Begin Doing." to "Walt Disney",
        "A good speech is like a pencil; it has to have a point." to "Unknown"

    )
    val colors = listOf(
        Color(0xFFBBDEFB), // Light Blue
        Color(0xFFFFCDD2), // Light Red
        Color(0xFFC8E6C9), // Light Green
        Color(0xFFFFF4B4), // Light Yellow
        Color(0xFFD1C5F9)  // Light Purple
    )
     var currentIndex by remember { mutableStateOf(0) }
    var backgroundColor by remember { mutableStateOf(colors.random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Quote Generator",
                        modifier = Modifier
                        .fillMaxWidth()
                    .padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                ))},
                navigationIcon = {
                    IconButton(onClick = onBack){
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
                ,
                        colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = backgroundColor,
            ))
        },


    ){ innerPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "\"${quotes[currentIndex].first}\"",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "— ${quotes[currentIndex].second}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            currentIndex = (quotes.indices).random()
            backgroundColor = colors.random()
        })
        {
            Text("Next Quote")
        }

        OutlinedButton(onClick = onBack) {
            Text("Back to Home")
        }


    }
    }
}