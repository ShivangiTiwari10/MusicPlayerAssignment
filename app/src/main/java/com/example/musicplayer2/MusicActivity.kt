package com.example.musicplayer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer2.`interface`.MusicInterface
import com.example.musicplayer2.databinding.ActivityMusicBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicBinding

    private lateinit var myadapter: MusicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(
                "https://spotify23.p.rapidapi.com/"

            )
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
            .create(MusicInterface::class.java)
        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<PlayList?> {
            override fun onResponse(
                call: Call<PlayList?>,
                response: Response<PlayList?>
            ) {

                val responceBody = response.body()
                val musicList = responceBody?.images
                myadapter = MusicAdapter(musicList!!)
                binding.myRecycler.adapter = myadapter
                binding.myRecycler.layoutManager = LinearLayoutManager(this@MusicActivity)
            }

            override fun onFailure(call: Call<PlayList?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }


}