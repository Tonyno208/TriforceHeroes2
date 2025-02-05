package com.example.triforceheroes

data class Game(
    val id: String,
    val title: String,
    val releaseYear: String,
    val platform: String,
    val description: String,
    var userNotes: String,
    val imagen: String,
    var isFavorite: Boolean
)
