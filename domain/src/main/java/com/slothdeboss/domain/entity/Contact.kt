package com.slothdeboss.domain.entity

data class Contact(
    var id: Long = 0,
    val imageUrl: String,
    val name: String,
    val surname: String,
    val email: String?
)