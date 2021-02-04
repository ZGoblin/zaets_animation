package com.example.zaetsanimation

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zaetsanimation.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity: AppCompatActivity() {
    private val binding: ActivityContactDetailsBinding by lazy {
        ActivityContactDetailsBinding.inflate(layoutInflater)
    }

    companion object {
        private const val CONTACT = "CONTACT"

        fun start(context: Context, contact: Contact, activityOptions: ActivityOptions? = null) {
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra(CONTACT, contact)

            context.startActivity(intent, activityOptions?.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setupListener()
        setupData()
    }

    private fun setupData() {
        val contact = intent.getParcelableExtra<Contact>(CONTACT)
        binding.apply {
            contact?.let { contact ->
                tvName.text = contact.name
                tvPhoneNumber.text = contact.phone
                ivAvatar.setImageResource(contact.avatar)
            }
        }
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}