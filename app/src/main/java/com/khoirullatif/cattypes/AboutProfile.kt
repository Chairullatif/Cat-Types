package com.khoirullatif.cattypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_profile)

        supportActionBar?.title = "About Me"
    }
}
