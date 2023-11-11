package com.example.himalayantracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.himalayantracker.ui.hotelsadapter

class BookHotels : AppCompatActivity() {
    lateinit var hotelslist : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    val hotel1List = arrayListOf("Hi", "hello", "by")
    lateinit var hotels1adapter : hotelsadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_hotels)
        hotelslist = findViewById(R.id.ht_recyclerview)
        layoutManager = LinearLayoutManager(this@BookHotels)
        hotels1adapter = hotelsadapter(this@BookHotels,hotel1List)
        hotelslist.adapter = hotels1adapter
        hotelslist.layoutManager = layoutManager



    }
}