package com.example.zaetsanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zaetsanimation.databinding.ActivityContactDetailsBinding
import com.example.zaetsanimation.databinding.ActivityMainBinding

class ContactsActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            rvContacts.adapter = ContactsRecyclerAdapter(getContacts(), this@ContactsActivity)
            rvContacts.layoutManager = LinearLayoutManager(this@ContactsActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun getContacts() : List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact("Oleh Zaiets", "0957808465", R.drawable.ic_launcher_foreground))
        contacts.add(Contact("Bus station", "0664864213", R.drawable.ic_launcher_background))
        contacts.add(Contact("Maria Kozak", "0954616484", R.drawable.ic_launcher_foreground))
        contacts.add(Contact("Julia Jupyter", "0504876548", R.drawable.ic_launcher_background))
        contacts.add(Contact("Nikola Tesla", "0991354684", R.drawable.ic_launcher_foreground))
        contacts.add(Contact("Peter the First", "0674684518", R.drawable.ic_launcher_background))
        contacts.add(Contact("Ivan the Terrible", "0958465188", R.drawable.ic_launcher_foreground))

        return contacts
    }
}