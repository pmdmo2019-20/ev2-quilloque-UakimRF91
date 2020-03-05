package es.iessaladillo.pedrojoya.quilloque.ui.contacts.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.QuilloQueDatabase
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import kotlinx.android.synthetic.main.contact_creation_fragment.*

class AddContact : Fragment(R.layout.contact_creation_fragment) {
    private val viewModel: AddContactViewModel by viewModels {
        AddContactViewModelFactory(
            QuilloQueDatabase.getInstance
                (this.requireContext()).contactDao, requireActivity().application
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        fabSave.setOnClickListener {
            if (txtName.text.isNotBlank() && txtPhoneNumber.text.isNotBlank()) {
                viewModel.addContact(Contact(0, txtName.text.toString(), txtPhoneNumber.text.toString()))
            }
        }
    }

}