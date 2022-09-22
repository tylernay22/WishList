package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wLists: MutableList<WList>
    lateinit var wlistRv : RecyclerView

    lateinit var etName : TextView
    lateinit var etPrice : TextView
    lateinit var etUrl : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wlistRv = findViewById<RecyclerView>(R.id.rvWLists)
        etName = findViewById(R.id.etName)
        etPrice = findViewById(R.id.etPrice)
        etUrl = findViewById(R.id.etUrl)


        wLists = mutableListOf()
        val wlistAdapter = WListAdapter(wLists)

        wlistRv.adapter = wlistAdapter
        wlistRv.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.Button).setOnClickListener {
            val newWish = WList(
                etName.text.toString(),
                etPrice.text.toString(),
                etUrl.text.toString()
            )
            wLists.add(newWish)
            wlistAdapter.notifyDataSetChanged()

            wlistRv.smoothScrollToPosition(wLists.lastIndex)
        }

        }

    }
