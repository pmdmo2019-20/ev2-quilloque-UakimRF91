package es.iessaladillo.pedrojoya.quilloque.ui.recent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.pojo.RecentWithContact
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recent_fragment_item.view.*

class RecentFragmentAdapter : ListAdapter<RecentWithContact, RecentFragmentAdapter.ViewHolder>(CallDiffCallback) {

    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recent_fragment_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recentWithContact = currentList[position]
        holder.bind(recentWithContact)
    }

    inner class ViewHolder (override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        init {
            containerView.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }

        fun bind(recentWithContact: RecentWithContact) {
            recentWithContact.run {
                containerView.lblName.text = name
                containerView.lblDate.text = date
                containerView.lblTime.text = hour
                when (callType) {
                    "Entrante" -> containerView.imgCallType.setImageResource(R.drawable.ic_call_received_black_24dp)
                    "Saliente" -> containerView.imgCallType.setImageResource(R.drawable.ic_call_made_black_24dp)
                    "Perdida" -> containerView.imgCallType.setImageResource(R.drawable.ic_call_missed_black_24dp)
                    "Perdida" -> containerView.imgCallType.setImageResource(R.drawable.ic_video_call_black_24dp)
                }
                containerView.lblPhoneNumber.text = phoneNumber

            }
        }
    }


    object CallDiffCallback: DiffUtil.ItemCallback<RecentWithContact>() {
        override fun areItemsTheSame(oldItem: RecentWithContact, newItem: RecentWithContact): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: RecentWithContact, newItem: RecentWithContact): Boolean {
            return oldItem == newItem
        }
    }
}