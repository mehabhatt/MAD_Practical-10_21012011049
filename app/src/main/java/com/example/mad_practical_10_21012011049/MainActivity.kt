package com.example.mad_practical_10_21012011049

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var personListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn= findViewById<FloatingActionButton>(R.id.autorenew_btn)
        btn.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "dchj8v1b6qqdjzbqood1jgpachyfzlw58r540gru")
                    withContext(Dispatchers.Main) {
                        try {
                            if(data != null)
                                runOnUiThread{getPersonDetailsFromJson(data)}
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getPersonDetailsFromJson(sJson: String) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val personListView=findViewById<ListView>(R.id.listview_main)
            personListView.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }

    /*fun setArraytoListView(){
      val personListView=findViewById<ListView>(R.id.listview_main)
        val array = arrayListOf<Person>(
            Person("1", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 230117.83,723446.96),
                    Person("1", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 172.455, 90.99),
        Person("3", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 172.455, 90.9),
        Person("4", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 172.455, 90.1),
        Person("5", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 172.455, 90.2),
        Person("6", "Meha Bhatt", "meha21@gmail.com", "9452321000", "S-21, Someshwar Flats, Ahemdabad", 172.455, 90.3)
        )
        personListView.adapter=PersonAdapter(this, array)
    }*/

}

