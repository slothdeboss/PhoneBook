package com.slothdeboss.data.di

import com.slothdeboss.data.mapper.ContactEntityMapper
import com.slothdeboss.data.repository.ContactRepositoryImpl
import com.slothdeboss.domain.repository.ContactRepository
import org.koin.dsl.module
import org.koin.experimental.builder.factory

val dataModule = module {

    factory<ContactEntityMapper>()
    factory<ContactRepository> { ContactRepositoryImpl(get(), get()) }

}