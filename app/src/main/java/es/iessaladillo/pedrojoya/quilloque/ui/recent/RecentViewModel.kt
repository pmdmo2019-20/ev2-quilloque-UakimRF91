package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.quilloque.base.Event
import es.iessaladillo.pedrojoya.quilloque.data.dao.RecentContactDao
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentWithContact

class RecentViewModel(
    private val recentContactDao: RecentContactDao,
    private val application: Application
) : ViewModel() {

    init {
        queryAllRecentContact()
    }

    private val _recentContact: MutableLiveData<List<RecentWithContact>> = MutableLiveData()
    val recentContact: LiveData<List<RecentWithContact>>
        get() = _recentContact

    private val _message: MutableLiveData<Event<String>> = MutableLiveData()
    val message: LiveData<Event<String>>
        get() = _message

    fun queryAllRecentContact() {
        _recentContact.value = recentContactDao.queryAllRecentContact().value
    }
}