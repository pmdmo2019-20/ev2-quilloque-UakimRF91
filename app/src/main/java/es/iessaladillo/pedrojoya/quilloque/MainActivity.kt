package es.iessaladillo.pedrojoya.quilloque

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.quilloque.ui.contacts.ContactsFragment
import es.iessaladillo.pedrojoya.quilloque.ui.dial.DialFragment
import es.iessaladillo.pedrojoya.quilloque.ui.recent.RecentFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()
        if (savedInstanceState == null) {
            navigateToStartFragment()
        }
    }

    private fun setupViews() {
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateToOption(it)
            true
        }
    }

    private fun navigateToStartFragment() {
        navigateToDial()
    }

    private fun navigateToDial() {
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, DialFragment.newInstance())
        }
    }

    private fun navigateToRecent() {
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, RecentFragment.newInstance())
        }
    }


    private fun navigateToContacts() {
        supportFragmentManager.commit {
            replace(
                R.id.navHostFragment, ContactsFragment.newInstance())
        }
    }

    private fun navigateToOption(item: MenuItem) {
        when (item.itemId) {
            R.id.mnuDial -> navigateToDial()
            R.id.mnuContacts -> navigateToContacts()
            R.id.mnuRecent -> navigateToRecent()
        }
    }


}
