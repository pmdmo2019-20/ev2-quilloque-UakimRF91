package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val contactId: Long = 0,
    var contactName: String?,
    val contactPhoneNumber: String?
)