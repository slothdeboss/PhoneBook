package com.slothdeboss.phonebook.event

import com.slothdeboss.domain.entity.Contact

sealed class ContactEvent

object LoadAllContacts: ContactEvent()
data class LoadContactById(val id: Long): ContactEvent()
data class UpdateContact(val contact: Contact): ContactEvent()
data class CreateContact(val contact: Contact): ContactEvent()
data class DeleteContact(val contact: Contact): ContactEvent()