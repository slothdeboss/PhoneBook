package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.repository.ContactRepository

class FetchAllContactsUseCase(
    private val repository: ContactRepository
) {

    fun execute() = repository.fetchAllContacts()

}