package com.khoirullatif.cattypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_detail)

        val tvType: TextView = findViewById(R.id.tv_detail_type)
        val tvDetail: TextView = findViewById(R.id.tv_detail_details)
        val ivImage: ImageView = findViewById(R.id.iv_item_cat_detail)
        val tvPrice: TextView = findViewById(R.id.tv_price)

        val typeReceived = intent.getStringExtra("TYPE_CAT")
        val detailReceived = intent.getStringExtra("DETAIL_CAT")
        val priceReceived = intent.getStringExtra("PRICE_CAT")
        val imageReceived = intent.getIntExtra("IMAGE_CAT", 0)

        tvType.text = typeReceived
        tvDetail.text = detailReceived
        ivImage.setImageResource(imageReceived)
        tvPrice.text = priceReceived

        supportActionBar?.title = "Detail Kucing"
    }
}
