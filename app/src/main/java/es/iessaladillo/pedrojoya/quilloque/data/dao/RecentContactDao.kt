package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentWithContact

@Dao
interface RecentContactDao {

    @Query("SELECT COALESCE(contactName, ''), recentPhoneNumber, recentCallType, recentDate, recentHour FROM Recent LEFT JOIN Contact ON recentPhoneNumber = contactPhoneNumber ORDER BY recentId")
    fun queryAllRecentContact(): LiveData<List<RecentWithContact>>
}