package com.example.mad_practical_10_21012011049
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import java.util.ArrayList

class PersonAdapter(context:Context,  val Personarray : ArrayList<Person>): ArrayAdapter<Person>(context,0,Personarray) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return view
    }
}