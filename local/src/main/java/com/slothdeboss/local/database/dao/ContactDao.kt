package com.slothdeboss.local.database.dao

import androidx.room.*
import com.slothdeboss.local.entity.LocalContact

@Dao
interface ContactDao {

    @Query("SELECT * FROM LocalContact")
    fun getAllContacts(): List<LocalContact>

    @Query("SELECT * FROM LocalContact WHERE id LIKE :id")
    fun getContactById(id: Long): LocalContact

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(contact: LocalContact)

    @Query("DELETE FROM LocalContact WHERE id LIKE :id")
    fun deleteContact(id: Long)

    @Insert
    fun addAll(contacts: List<LocalContact>)

    @Query("DELETE FROM LocalContact")
    fun clearDatabase()
}