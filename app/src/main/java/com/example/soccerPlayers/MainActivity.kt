package com.example.soccerPlayers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.soccerPlayers.ui.theme.SoccerPlayersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "world!")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    SoccerPlayersTheme {
        Surface {
            Text(text = "Hello $name!", modifier = modifier)
        }
    }
}

data class Player(val author: String, val body: String, val profileImageUrl: String)

@Composable
fun PlayerListElement(playerList: Collection<Player>) {
    playerList.map { PlayerCard(it) }
}

@Composable
fun PlayerCard(player: Player) {
    Row(modifier = Modifier.fillMaxWidth(0.5f)) {
        Column(modifier = Modifier
                .clickable { }) {
            AsyncImage(model = player.profileImageUrl, modifier = Modifier.fillMaxWidth(), contentDescription = "Translated description of what the image contains")
            Column {
                Text(text = player.author, textAlign = TextAlign.Center)
                Text(text = player.body)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SoccerPlayersTheme {
        PlayerListElement(playerList = listOf(Player("Sween", "hello", "https://resources.premierleague.com/premierleague/photos/players/250x250/p225321.png")))
    }
}