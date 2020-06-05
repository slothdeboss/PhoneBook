package com.slothdeboss.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalContact(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val imageUrl: String,
    val name: String,
    val surname: String,
    val email: String?
)