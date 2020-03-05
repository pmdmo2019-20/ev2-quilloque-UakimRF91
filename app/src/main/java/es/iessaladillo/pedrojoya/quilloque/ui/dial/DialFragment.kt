package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.quilloque.R

class DialFragment : Fragment(R.layout.dial_fragment) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(): DialFragment = DialFragment()
    }
}