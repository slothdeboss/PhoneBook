package com.slothdeboss.data.source

import com.slothdeboss.data.entity.ContactModel

interface LocalDataSource {

    fun getAll(): List<ContactModel>
    fun getById(id: Long): ContactModel
    fun update(entity: ContactModel)
    fun delete(id: Long)
    fun refreshDatabase()

}