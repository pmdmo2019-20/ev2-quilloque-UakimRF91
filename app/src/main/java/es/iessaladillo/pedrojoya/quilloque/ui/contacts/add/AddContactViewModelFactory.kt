package es.iessaladillo.pedrojoya.quilloque.ui.contacts.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao

class AddContactViewModelFactory (
    private val contactDao: ContactDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        AddContactViewModel(contactDao, application) as T
}