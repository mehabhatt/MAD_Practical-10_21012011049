package com.example.mad_practical_10_21012011049

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var personListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        personListView = findViewById(R.id.listview_main)
        val btn = findViewById<FloatingActionButton>(R.id.autorenew_btn)
    }
    fun setPersonData(){
        personListView.adapter=PersonAdapter(this,
            arrayListOf(
                //Person("1", "John","John123@gmail.com", "9765431340","Ahmedabad",21.7051,72.9959),

    }
}

