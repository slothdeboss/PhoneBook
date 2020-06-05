package com.slothdeboss.data.entity

data class ContactModel(
    val id: Long = 0,
    val imageUrl: String,
    val name: String,
    val surname: String,
    val email: String?
)
