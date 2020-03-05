package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentWithContact

@Dao
interface RecentContactDao {

    @Query("SELECT COALESCE(contactName, '') as name, recentPhoneNumber as phoneNumber, recentCallType as callType, recentDate as date, recentHour as hour FROM Recent LEFT JOIN Contact ON recentPhoneNumber = contactPhoneNumber LIMIT 20")
    fun queryAllRecentContact(): LiveData<List<RecentWithContact>>
}