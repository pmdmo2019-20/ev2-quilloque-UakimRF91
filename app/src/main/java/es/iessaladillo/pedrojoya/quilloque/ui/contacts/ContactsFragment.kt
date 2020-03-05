package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.quilloque.R

class ContactsFragment : Fragment(R.layout.contacts_fragment) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(): ContactsFragment = ContactsFragment()
    }
}