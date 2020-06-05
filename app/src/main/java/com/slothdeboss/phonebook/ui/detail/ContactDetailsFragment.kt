package com.slothdeboss.phonebook.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.state.*
import com.slothdeboss.phonebook.R
import com.slothdeboss.phonebook.base.BaseFragment
import com.slothdeboss.phonebook.event.LoadContactById
import kotlinx.android.synthetic.main.fragment_contact_details.*

class ContactDetailsFragment : BaseFragment(R.layout.fragment_contact_details) {

    private var contactId: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            contactId = ContactDetailsFragmentArgs.fromBundle(it).contactId
            viewModel.renderEvent(event = LoadContactById(id = contactId))
        }
    }

    override fun observeState() {
        viewModel.state.observe(viewLifecycleOwner, Observer { state->
            when (state) {
                OnLoadingState -> onLoadingState()
                is OnContactLoadedState -> onContactLoadedState(contact = state.contact)
                is OnErrorState -> onErrorState(message = state.message)
            }
        })
    }

    private fun onContactLoadedState(contact: Contact) {
        loadContactInFragment(contact = contact)
        detailLoadingBar.visibility = View.GONE
        contactContainer.visibility = View.VISIBLE
    }

    private fun onLoadingState() {
        contactContainer.visibility = View.GONE
        detailLoadingBar.visibility = View.VISIBLE
    }

    private fun loadContactInFragment(contact: Contact) {
        contactName.text = contact.name
        contactSurname.text = contact.surname
        contactEmail.text = contact.email ?: "Unknown"
    }

    private fun onErrorState(message: String) {
        displayMessage(message = message)
    }
}