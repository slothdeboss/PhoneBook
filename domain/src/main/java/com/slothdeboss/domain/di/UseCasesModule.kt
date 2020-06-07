package com.slothdeboss.domain.di

import com.slothdeboss.domain.usecases.*
import org.koin.dsl.module
import org.koin.experimental.builder.factory

val useCasesModule = module {
    factory<UpdateContactUseCase>()
    factory<FetchAllContactsUseCase>()
    factory<FetchContactByIdUseCase>()
    factory<DeleteContactUseCase>()
    factory<RefreshDatabaseUseCase>()
}