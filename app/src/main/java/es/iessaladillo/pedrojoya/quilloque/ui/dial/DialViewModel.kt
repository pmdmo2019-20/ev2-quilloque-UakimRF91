package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.base.Event
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import java.lang.Exception
import kotlin.concurrent.thread

class DialViewModel(
    private val contactDao: ContactDao,
    private val application: Application
) : ViewModel() {

    init {
        queryAllContacts()
    }

    private val _contact: MutableLiveData<List<Contact>> = MutableLiveData()
    val contact: LiveData<List<Contact>>
        get() = _contact

    private val _message : MutableLiveData<Event<String>> = MutableLiveData()
    val message : LiveData<Event<String>>
        get()=_message


    private fun queryAllContacts() {
        _contact.postValue(contactDao.queryAllContacts().value)
    }

    fun addCall(phoneNumber: String) {
        thread {
            try {
                contactDao.insertContact(Contact(0, "paco", phoneNumber))
            } catch (e: Exception) {
                _message.postValue(Event("ERROR"))
            }
        }
    }
}