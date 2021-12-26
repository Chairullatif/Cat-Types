package com.khoirullatif.cattypes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCats: RecyclerView
    private var list: ArrayList<Cat> = arrayListOf()
    private var newTitle: String = "Jenis-Jenis Kucing"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCats = findViewById(R.id.recycler_view)
        rvCats.setHasFixedSize(true)

        list.addAll(CatsData.listData)
        showRecyclerList()

        Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show()

        supportActionBar?.title = newTitle
    }

    private fun showRecyclerList (){
        rvCats.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCats.adapter = listCatAdapter

//        listCatAdapter.setOnItemCallback(object: ListCatAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Cat) {
//                val moveIntent = Intent(this@MainActivity, CatDetailActivity::class.java)
//                startActivity(moveIntent)
//            }
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_action_about -> {val intent = Intent(this, AboutProfile::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
