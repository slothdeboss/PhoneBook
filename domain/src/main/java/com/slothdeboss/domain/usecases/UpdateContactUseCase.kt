package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.repository.ContactRepository

class UpdateContactUseCase(
    private val repository: ContactRepository
) {

    fun execute(contact: Contact) = repository.updateContact(contact = contact)

}