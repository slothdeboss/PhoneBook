package com.slothdeboss.local.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun uiScope(action: () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        action()
    }
}