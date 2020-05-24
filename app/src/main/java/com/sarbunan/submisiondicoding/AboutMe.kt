package com.sarbunan.submisiondicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val actionbar = supportActionBar
        actionbar!!.title = "Profil Saya"

        val imgMe : ImageView = findViewById(R.id.img_item_photo)

        val sImg = "https://d17ivq9b7rppb3.cloudfront.net/small/avatar/20190813190707b90ab91452faceadceab25c9d55a23e6.jpg"

        Glide.with(this)
            .load(sImg)
            .apply(RequestOptions())
            .into(imgMe)
    }
}
