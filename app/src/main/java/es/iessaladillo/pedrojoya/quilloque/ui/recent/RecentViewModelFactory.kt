package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.quilloque.data.dao.RecentContactDao

class RecentViewModelFactory (
    private val recentContactDao: RecentContactDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        RecentViewModel(recentContactDao, application) as T
}