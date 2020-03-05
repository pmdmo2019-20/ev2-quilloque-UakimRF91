package es.iessaladillo.pedrojoya.quilloque.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import es.iessaladillo.pedrojoya.quilloque.data.entity.Recent

@Dao
interface RecentDao {

    @Insert
    fun insertRecent(recent: Recent)

    @Query("SELECT * FROM Recent")
    fun queryAllRecents(): LiveData<List<Recent>>

}