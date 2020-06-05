package com.slothdeboss.data.mapper

interface BaseEntityMapper<E, M> {

    fun toEntity(model: M): E
    fun toModel(entity: E): M

}