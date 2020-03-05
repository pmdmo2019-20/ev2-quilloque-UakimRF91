package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao

class ContactsViewModelFactory (
    private val contactDao: ContactDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ContactsViewModel(contactDao, application) as T
}