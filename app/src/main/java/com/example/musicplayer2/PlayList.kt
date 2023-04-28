package com.example.musicplayer2

data class PlayList(
    val collaborative: Boolean,
    val description: String,
    val followers: Followers,
    val images: List<Image>,
    val name: String,
    val owner: Owner,
    val `public`: Boolean,
    val tracks: Tracks,
    val uri: String
)