package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.QuilloQueDatabase
import kotlinx.android.synthetic.main.recent_fragment.*

class RecentFragment : Fragment(R.layout.recent_fragment) {

    private val viewModel: RecentViewModel by viewModels {
        RecentViewModelFactory(
            QuilloQueDatabase.getInstance
                (this.requireContext()).recentContactDao, requireActivity().application
        )
    }
    private val listAdapter: RecentFragmentAdapter = RecentFragmentAdapter().also {
        it.onItemClickListener = { position -> showButtons(position) }
    }

    private fun showButtons(position: Int) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        observeLiveData()
        setupRecyclerView()
    }

    private fun observeLiveData() {
        viewModel.recentContact.observe(viewLifecycleOwner) {
            viewModel.queryAllRecentContact()
            listAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        lstCalls.run {
            setHasFixedSize(true)
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }


    companion object {
        fun newInstance(): RecentFragment = RecentFragment()
    }

}