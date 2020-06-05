package com.slothdeboss.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.slothdeboss.local.database.dao.ContactDao
import com.slothdeboss.local.entity.LocalContact
import com.slothdeboss.local.source.PrepopulateSource
import com.slothdeboss.local.util.uiScope

@Database(entities = [LocalContact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getContactDao(): ContactDao

    companion object{
        const val DATABASE_NAME = "Contacts.db"

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .addCallback(object: Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    uiScope {
                        getInstance(context).getContactDao().addAll(
                            PrepopulateSource.getPrepopulateContacts()
                        )
                    }
                }
            })
            .build()
    }

}