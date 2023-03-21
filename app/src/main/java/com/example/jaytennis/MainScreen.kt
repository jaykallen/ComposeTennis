package com.example.jaytennis

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.NavController
import com.example.jaytennis.Screen.DetailScreen.withArgs
import org.koin.java.KoinJavaComponent.inject

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {

    val playerList by mainViewModel.playerPass.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { mainViewModel.doNetworkCall() },
            modifier = Modifier.padding(8.dp),
        ) {
            Text(
                text = "Run Api"
            )
        }
        Text(
            text = "Code = ${mainViewModel.apiPass}",
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(playerList.size) { player ->
                ListItem(navController, player = playerList[player])
            }
        }
    }
}

@Composable
fun ListItem(navController: NavController, player: Player) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(
                        withArgs(
                            player.name, player.country, player.age.toString(), player.rank.toString(), player.height, player.coach
                        )
                    )
                },
        ) {
            Text(
                text = player.name,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = player.country,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = player.age.toString(),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
