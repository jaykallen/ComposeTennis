package com.example.jaytennis

data class Players(
    val players: List<Player>,
)

data class Player(
    val name: String,
    val country: String,
    val age: Long,
    val rank: Long,
    val height: String,
    val coach: String,
    val born: String,
    val highestRank: Long,
    val singlesTitles: Long,
    val doublesTitles: Long,
    val earnings: String,
    val sponsors: List<String>
)
