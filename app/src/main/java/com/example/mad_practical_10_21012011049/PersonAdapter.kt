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

class PersonAdapter(context:Context, val array: ArrayList<Person>): ArrayAdapter<Person>(context,0,array) {




    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        val person_data = array.get(position)
        /* view.findViewById<TextView>(R.id.name_textView).text=person_data.name
        view.findViewById<TextView>(R.id.number_textView).text=person_data.phoneNo
        view.findViewById<TextView>(R.id.email_textView).text=person_data.emailId
        view.findViewById<TextView>(R.id.address_textView).text=person_data.address */
        view.findViewById<MaterialButton>(R.id.location_btn).setOnClickListener {

        }
        return view
    }

}