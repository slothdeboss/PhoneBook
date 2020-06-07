package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.repository.ContactRepository

class DeleteContactUseCase(
    private val repository: ContactRepository
) {

    fun execute(id: Long) = repository.deleteContact(id = id)

}