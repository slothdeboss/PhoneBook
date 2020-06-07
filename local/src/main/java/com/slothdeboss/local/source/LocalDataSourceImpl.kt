package com.slothdeboss.local.source

import com.slothdeboss.data.entity.ContactModel
import com.slothdeboss.data.source.LocalDataSource
import com.slothdeboss.local.database.dao.ContactDao
import com.slothdeboss.local.mapper.LocalContactMapper

class LocalDataSourceImpl(
    private val dao: ContactDao,
    private val mapper: LocalContactMapper
): LocalDataSource {

    override fun getAll(): List<ContactModel> {
        return dao.getAllContacts().map{ localContact ->
            mapper.toModel(local = localContact)
        }
    }

    override fun getById(id: Long): ContactModel {
        val localContact = dao.getContactById(id = id)
        return mapper.toModel(local = localContact)
    }

    override fun update(entity: ContactModel) {
        val localContact = mapper.toLocal(model = entity)
        dao.updateContact(contact = localContact)
    }

    override fun delete(id: Long) {
        dao.deleteContact(id = id)
    }

    override fun refreshDatabase() {
        dao.clearDatabase()
        dao.addAll(contacts = PrepopulateSource.getPrepopulateContacts())
    }

}