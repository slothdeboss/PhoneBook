package com.slothdeboss.domain.state

import com.slothdeboss.domain.entity.Contact

sealed class ContactsState

object OnLoadingState: ContactsState()
object OnActionSuccessState: ContactsState()
data class OnContactLoadedState(val contact: Contact): ContactsState()
data class OnContactListLoadedState(val contacts: List<Contact>): ContactsState()
data class OnErrorState(val message: String): ContactsState()