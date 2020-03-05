package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.contacts_fragment_item.view.*

class ContactsFragmentAdapter : ListAdapter<Contact, ContactsFragmentAdapter.ViewHolder>(CallDiffCallback) {

    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.contacts_fragment, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacts = currentList[position]
        holder.bind(contacts)
    }

    inner class ViewHolder (override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        init {
            containerView.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }

        fun bind(contact: Contact) {
            contact.run {
                containerView.lblName.text = contactName
                containerView.lblPhoneNumber.text = contactPhoneNumber
            }
        }
    }


    object CallDiffCallback: DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }
}