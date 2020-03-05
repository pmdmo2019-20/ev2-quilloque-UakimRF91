package es.iessaladillo.pedrojoya.quilloque.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recent (
    @PrimaryKey(autoGenerate = true)
    val recentId: Long = 0,
    var recentPhoneNumber: String,
    val recentCallType: String,
    val recentDate: String,
    val recentHour: String
)