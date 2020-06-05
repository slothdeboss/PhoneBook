package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.repository.ContactRepository

class DeleteContactUseCase(
    private val repository: ContactRepository
) {

    fun execute(contact: Contact) = repository.deleteContact(contact = contact)

}