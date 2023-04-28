package com.example.musicplayer2.`interface`

import com.example.musicplayer2.PlayList
import retrofit2.Call
import retrofit2.http.GET

interface MusicInterface {
    @GET("playlist")
    fun getProductData(): Call<PlayList>
}