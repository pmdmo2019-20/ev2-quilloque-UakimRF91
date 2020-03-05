package es.iessaladillo.pedrojoya.quilloque.ui.contacts.add

import android.app.Application
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import java.lang.Exception
import kotlin.concurrent.thread

class AddContactViewModel (
    private val contactDao: ContactDao,
    private val application: Application
) : ViewModel() {

    fun addContact(contact: Contact) {
        thread {
            try {
                contactDao.insertContact(contact)
            } catch (e: Exception) {}
        }

    }

}