package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.repository.ContactRepository

class FetchContactByIdUseCase(
    private val repository: ContactRepository
) {

    fun execute(contactId: Long) = repository.fetchContactById(contactId = contactId)

}