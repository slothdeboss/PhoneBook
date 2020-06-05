package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.repository.ContactRepository

class CreateContactUseCase(
    private val repository: ContactRepository
) {

    fun execute(contact: Contact) = repository.createNewContact(contact = contact)

}