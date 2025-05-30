package com.example.kotlin_revision

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.text.Typography.quote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteGenerator() {
    var quotes by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    var quoteInput by remember { mutableStateOf("") }
    var speakerInput by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Quote Generator",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp
                        )
                    )
                }
            )
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            OutlinedTextField(
                value = quoteInput,
                onValueChange = { quoteInput = it },
                label = { Text("Add Quote") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = speakerInput,
                onValueChange = { speakerInput = it },
                label = { Text("Add Speaker") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (quoteInput.isNotBlank() && speakerInput.isNotBlank()) {
                        quotes = quotes + (quoteInput to speakerInput)
                        quoteInput = ""
                        speakerInput = ""
                    }
                },
            ) {
                Text("Add Quote")
            }

            Divider()

            LazyColumn {
                items(quotes) { (quote, speaker) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    )
                    {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(text = "\"$quote\"", style = MaterialTheme.typography.bodyLarge)
                            Text(
                                text = "- $speaker",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                    }
                }
            }
        }
    }
}