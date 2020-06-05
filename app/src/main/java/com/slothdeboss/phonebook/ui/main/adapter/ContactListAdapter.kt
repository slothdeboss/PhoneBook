package com.slothdeboss.phonebook.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.phonebook.R
import kotlinx.android.synthetic.main.contact_card.view.*

class ContactListAdapter: RecyclerView.Adapter<ContactListViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.contact_card, parent, false
        )
        return ContactListViewHolder(view = view)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact = contact)
    }

    fun refreshContacts(newContacts: List<Contact>) {
        contacts.clear()
        contacts.addAll(newContacts)
        notifyDataSetChanged()
    }
}

class ContactListViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(contact: Contact) {
        view.cardContactName.text = contact.name
    }

}