package com.slothdeboss.local.database.dao

import androidx.room.*
import com.slothdeboss.local.entity.LocalContact

@Dao
interface ContactDao {

    @Query("SELECT * FROM LocalContact")
    fun getAllContacts(): List<LocalContact>

    @Query("SELECT * FROM LocalContact WHERE id LIKE :id")
    fun getContactById(id: Long): LocalContact

    @Insert
    fun createContact(contact: LocalContact)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(contact: LocalContact)

    @Delete
    fun deleteContact(contact: LocalContact)

    @Insert
    fun addAll(contacts: List<LocalContact>)

}