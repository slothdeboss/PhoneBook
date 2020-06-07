package com.slothdeboss.domain.repository

import com.slothdeboss.domain.entity.Contact

interface ContactRepository {

    fun fetchAllContacts(): List<Contact>
    fun fetchContactById(contactId: Long): Contact
    fun updateContact(contact: Contact)
    fun deleteContact(id: Long)
    fun refreshDatabase()

}