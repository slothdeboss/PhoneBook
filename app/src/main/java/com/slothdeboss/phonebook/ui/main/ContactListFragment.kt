package com.slothdeboss.phonebook.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.state.*
import com.slothdeboss.phonebook.R
import com.slothdeboss.phonebook.base.BaseFragment
import com.slothdeboss.phonebook.event.LoadAllContacts
import com.slothdeboss.phonebook.ui.main.adapter.ContactListAdapter
import kotlinx.android.synthetic.main.fragment_contact_list.*

class ContactListFragment : BaseFragment(R.layout.fragment_contact_list) {

    private lateinit var contactRecyclerAdapter: ContactListAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        contactRecyclerAdapter = ContactListAdapter()
        viewModel.renderEvent(event = LoadAllContacts)
        setupRecycler()
    }
    
    override fun observeState() {
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                OnLoadingState -> onLoadingState()
                is OnContactListLoadedState -> onContactsLoadedState(contacts = state.contacts)
                is OnErrorState -> onErrorState(message = state.message)
            }
        })
    }

    private fun onContactsLoadedState(contacts: List<Contact>) {
        contactRecyclerAdapter.refreshContacts(newContacts = contacts)
        contactLoadingBar.visibility = View.GONE
        contactsList.visibility = View.VISIBLE
    }

    private fun onLoadingState() {
        contactsList.visibility = View.GONE
        contactLoadingBar.visibility = View.VISIBLE
    }

    private fun onErrorState(message: String) {
        contactLoadingBar.visibility = View.GONE
        displayMessage(message = message)
    }

    private fun setupRecycler() {
        contactsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactRecyclerAdapter
        }
    }
}