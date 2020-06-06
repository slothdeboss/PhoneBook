package com.slothdeboss.domain.usecases

import com.slothdeboss.domain.repository.ContactRepository

class RefreshDatabaseUseCase(
    private val repository: ContactRepository
) {

    fun execute() = repository.refreshDatabase()

}