package com.slothdeboss.local.di

import com.slothdeboss.data.source.LocalDataSource
import com.slothdeboss.local.database.AppDatabase
import com.slothdeboss.local.mapper.LocalContactMapper
import com.slothdeboss.local.source.LocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.experimental.builder.factory

val localModule = module {

    single {
        AppDatabase.getInstance(androidContext())
    }

    single {
        get<AppDatabase>().getContactDao()
    }

    factory<LocalContactMapper>()
    factory<LocalDataSource> { LocalDataSourceImpl(get(), get()) }

}