package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.base.Event
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

class ContactsViewModel(
    private val contactDao: ContactDao,
    private val application: Application
) : ViewModel() {

    init {
        queryAllContacts()
    }

    private val _contact: MutableLiveData<List<Contact>> = MutableLiveData()
    val contact: LiveData<List<Contact>>
        get() = _contact

    private val _message: MutableLiveData<Event<String>> = MutableLiveData()
    val message: LiveData<Event<String>>
        get() = _message

    fun queryAllContacts() {
        try {
            _contact.value = contactDao.queryAllContacts().value
        } catch (e: Exception) {}


    }
}