package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.quilloque.R

class RecentFragment : Fragment(R.layout.recent_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(): RecentFragment = RecentFragment()
    }

}