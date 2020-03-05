package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun queryAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE contactName = :contactName")
    fun searchContacts(contactName: String): LiveData<List<Contact>>
}