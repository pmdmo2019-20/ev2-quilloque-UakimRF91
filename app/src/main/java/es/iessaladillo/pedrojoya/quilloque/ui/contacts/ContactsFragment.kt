package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.QuilloQueDatabase
import kotlinx.android.synthetic.main.contacts_fragment.*

class ContactsFragment : Fragment(R.layout.contacts_fragment) {

    private val viewModel: ContactsViewModel by viewModels {
        ContactsViewModelFactory(
            QuilloQueDatabase.getInstance
                (this.requireContext()).contactDao, requireActivity().application
        )
    }
    private val listAdapter: ContactsFragmentAdapter = ContactsFragmentAdapter().also {
        it.onItemClickListener = { position -> showButtons(position) }
    }
    private fun showButtons(position: Int) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupButton()
        observeLiveData()
        setupRecyclerView()
    }

    private fun setupButton() {
        emptyView.setOnClickListener {
            navigateToAddContact()
        }
    }

    private fun navigateToAddContact() {
        findNavController().navigate(R.id.navigateToAddContact)
    }

    private fun observeLiveData() {
        viewModel.contact.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        lstContacts.run {
            setHasFixedSize(true)
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    companion object {
        fun newInstance(): ContactsFragment = ContactsFragment()
    }
}