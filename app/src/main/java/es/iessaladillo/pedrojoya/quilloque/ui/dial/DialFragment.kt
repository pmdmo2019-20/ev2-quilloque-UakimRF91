package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.QuilloQueDatabase
import kotlinx.android.synthetic.main.dial_fragment.*

class DialFragment : Fragment(R.layout.dial_fragment) {

    private val viewModel: DialViewModel by viewModels {
        DialViewModelFactory(
            QuilloQueDatabase.getInstance
                (this.requireContext()).contactDao, requireActivity().application
        )
    }
    private val listAdapter: DialFragmentAdapter = DialFragmentAdapter().also {
        it.onItemClickListener = { position -> getPhoneNumber(position) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupButtons()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        lstSuggestions.run {
            setHasFixedSize(true)
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun getPhoneNumber(position: Int) {

    }

    private fun setupButtons() {
        lblOne.setOnClickListener { writeDigit("1") }
        lblTwo.setOnClickListener { writeDigit("2") }
        lblThree.setOnClickListener { writeDigit("3") }
        lblFour.setOnClickListener { writeDigit("4") }
        lblFive.setOnClickListener { writeDigit("5") }
        lblSix.setOnClickListener { writeDigit("6") }
        lblSeven.setOnClickListener { writeDigit("7") }
        lblEight.setOnClickListener { writeDigit("8") }
        lblNine.setOnClickListener { writeDigit("9") }
        lblZero.setOnClickListener { writeDigit("0") }
        lblAstherisc.setOnClickListener { writeDigit("*") }
        lblPound.setOnClickListener { writeDigit("#") }
        fabCall.setOnClickListener { addCall() }
        imgBackspace.setOnClickListener {
            if (lblNumber.text.isNotEmpty()) {
                deleteDigit()
            }
        }
    }

    private fun addCall() {
        viewModel.addCall(lblNumber.text.toString())
    }

    private fun deleteDigit() {
        lblNumber.text = lblNumber.text.toString().substring(0, lblNumber.text.length - 1)
    }

    private fun writeDigit(digit: String) {
        lblNumber.text = lblNumber.text.toString().plus(digit)
    }

    companion object {
        fun newInstance(): DialFragment = DialFragment()
    }
}