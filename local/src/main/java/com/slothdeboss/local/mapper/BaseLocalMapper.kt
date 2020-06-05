package com.slothdeboss.local.mapper

interface BaseLocalMapper<L, M> {
    
    fun toLocal(model: M): L
    fun toModel(local: L): M
    
}