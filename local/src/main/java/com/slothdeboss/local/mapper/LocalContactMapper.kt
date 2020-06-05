package com.slothdeboss.local.mapper

import com.slothdeboss.data.entity.ContactModel
import com.slothdeboss.local.entity.LocalContact

class LocalContactMapper: BaseLocalMapper<LocalContact, ContactModel> {

    override fun toLocal(model: ContactModel): LocalContact {
        return LocalContact(
            id = model.id,
            imageUrl = model.imageUrl,
            name = model.name,
            surname = model.surname,
            email = model.email
        )
    }

    override fun toModel(local: LocalContact): ContactModel {
        return ContactModel(
            id = local.id,
            imageUrl = local.imageUrl,
            name = local.name,
            surname = local.surname,
            email = local.email
        )
    }
}