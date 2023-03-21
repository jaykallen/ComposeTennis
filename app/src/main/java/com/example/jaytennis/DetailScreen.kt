package com.example.jaytennis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(onBackClick: () -> Unit, id: String, title: String, author: String, status: String, fee: String, lastEdited: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = {
                onBackClick()
            },
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = "Back"
            )
        }
        Text(
            text = "$id",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "$title",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "$author",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "$status",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "$fee",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "$lastEdited",
            modifier = Modifier.padding(16.dp)
        )
    }
}