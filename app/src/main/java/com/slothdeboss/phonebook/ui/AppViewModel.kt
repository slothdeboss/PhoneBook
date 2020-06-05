package com.slothdeboss.phonebook.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.slothdeboss.domain.entity.Contact
import com.slothdeboss.domain.state.*
import com.slothdeboss.domain.usecases.*
import com.slothdeboss.phonebook.base.BaseViewModel
import com.slothdeboss.phonebook.event.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    private val fetchAllContactsUseCase: FetchAllContactsUseCase,
    private val fetchContactByIdUseCase: FetchContactByIdUseCase,
    private val createContactUseCase: CreateContactUseCase,
    private val updateContactUseCase: UpdateContactUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
): BaseViewModel() {

    override fun renderEvent(event: ContactEvent) {
        when (event) {
            LoadAllContacts -> onLoadAllContactsEvent()
            is LoadContactById -> onLoadByIdEvent(id = event.id)
            is UpdateContact -> onUpdateContactEvent(contact = event.contact)
            is CreateContact -> onCreateContactEvent(contact = event.contact)
            is DeleteContact -> onDeleteContactEvent(id = event.contactId)
        }
    }

    private fun onDeleteContactEvent(id: Long) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    deleteContactUseCase.execute(id = id)
                }
                _state.value = OnActionSuccessState
            } catch (e: Exception) {
                e.printStackTrace()
                pushErrorMessage(message = "Error occurred while deleting contact!")
            }
        }
    }

    private fun onCreateContactEvent(contact: Contact) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    createContactUseCase.execute(contact = contact)
                }
                _state.value = OnActionSuccessState
            } catch (e: Exception) {
                e.printStackTrace()
                pushErrorMessage(message = "Can't create new contact!")
            }
        }
    }

    private fun onUpdateContactEvent(contact: Contact) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    updateContactUseCase.execute(contact = contact)
                }
                _state.value = OnActionSuccessState
            } catch (e: Exception) {
                e.printStackTrace()
                pushErrorMessage(message = "Error occurred while updating contact!")
            }
        }
    }

    private fun onLoadByIdEvent(id: Long) {
        _state.value = OnLoadingState
        viewModelScope.launch {
            try {
                val contact = withContext(Dispatchers.IO) {
                    fetchContactByIdUseCase.execute(contactId = id)
                }
                _state.value = OnContactLoadedState(contact = contact)
            } catch (e: Exception) {
                e.printStackTrace()
                pushErrorMessage(message = "Error occurred while loading contact!")
            }
        }
    }

    private fun onLoadAllContactsEvent() {
        _state.value = OnLoadingState
        viewModelScope.launch {
            try {
                val contacts = withContext(Dispatchers.IO) {
                    fetchAllContactsUseCase.execute()
                }
                _state.value = OnContactListLoadedState(contacts = contacts)
            } catch (e: Exception) {
                e.printStackTrace()
                pushErrorMessage(message = "Can't load contacts!")
            }
        }
    }

    private fun pushErrorMessage(message: String) {
        _state.value = OnErrorState(message = message)
    }
}
