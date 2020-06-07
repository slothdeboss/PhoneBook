package com.slothdeboss.data.repository

import com.slothdeboss.data.mapper.ContactEntityMapper
import com.slothdeboss.data.source.LocalDataSource
import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.repository.ContactRepository

class ContactRepositoryImpl(
    private val localSource: LocalDataSource,
    private val mapper: ContactEntityMapper
): ContactRepository {

    override fun fetchAllContacts(): List<Contact> {
        return localSource.getAll()
            .map { contactModel ->
                mapper.toEntity(model = contactModel)
            }
    }

    override fun fetchContactById(contactId: Long): Contact {
        val model = localSource.getById(id = contactId)
        return mapper.toEntity(model = model)
    }

    override fun updateContact(contact: Contact) {
        val model = mapper.toModel(entity = contact)
        localSource.update(entity = model)
    }

    override fun deleteContact(id: Long) {
        localSource.delete(id = id)
    }

    override fun refreshDatabase() {
        localSource.refreshDatabase()
    }
}