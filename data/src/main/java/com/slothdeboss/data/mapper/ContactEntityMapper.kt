package com.slothdeboss.data.mapper

import com.slothdeboss.data.entity.ContactModel
import com.slothdeboss.domain.entity.Contact

class ContactEntityMapper: BaseEntityMapper<Contact, ContactModel> {

    override fun toEntity(model: ContactModel): Contact {
        return Contact(
            id = model.id,
            name = model.name,
            surname = model.surname,
            imageUrl = model.imageUrl,
            email = model.email
        )
    }

    override fun toModel(entity: Contact): ContactModel {
        return ContactModel(
            id = entity.id,
            name = entity.name,
            surname = entity.surname,
            imageUrl = entity.imageUrl,
            email = entity.email
        )
    }
}