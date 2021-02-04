package com.example.zaetsanimation

import android.app.ActivityOptions
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.util.toAndroidPair
import androidx.recyclerview.widget.RecyclerView
import com.example.zaetsanimation.databinding.ContactsRecyclerviewBinding

class ContactsRecyclerAdapter(private val list: List<Contact>, private val activity: ContactsActivity): RecyclerView.Adapter<ContactHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contacts_recyclerview, parent, false)

        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.onBind(list[position], activity)
    }

    override fun getItemCount(): Int = list.size
}

class ContactHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding: ContactsRecyclerviewBinding by lazy {
        ContactsRecyclerviewBinding.bind(view)
    }

    fun onBind(contact: Contact, activity: ContactsActivity) {
        binding.apply {
            tvName.text = contact.name
            tvPhoneNumber.text = contact.phone
            ivAvatar.setImageResource(contact.avatar)
            ivAvatar.setOnClickListener {
                val pairAvatar = Pair<View, String>(
                    ivAvatar,
                    it.context.getString(R.string.transition_avatar)
                ).toAndroidPair()
                val pairName = Pair<View, String>(
                    tvName,
                    it.context.getString(R.string.transition_contact_name)
                ).toAndroidPair()
                val pairPhone = Pair<View, String>(
                    tvPhoneNumber,
                    it.context.getString(R.string.transition_contact_phone)
                ).toAndroidPair()
                val pairContainer = Pair<View, String>(
                    cvContact,
                    it.context.getString(R.string.transition_container)
                ).toAndroidPair()
                val activityOptions = ActivityOptions
                    .makeSceneTransitionAnimation(activity, pairAvatar, pairName, pairPhone, pairContainer)

                ContactDetailsActivity.start(it.context, contact, activityOptions)
            }
        }
    }
}