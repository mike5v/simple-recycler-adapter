package it.mike5v.example.item

import android.view.View
import com.squareup.picasso.Picasso
import it.mike5v.example.Header
import it.mike5v.example.R
import it.mike5v.simplerecycleradapter.SimpleRecyclerAdapter
import kotlinx.android.synthetic.main.item_header.view.*

/**
 * Created by Michele Quintavalle
 */
class HeaderItem(private val header: Header): SimpleRecyclerAdapter.AdapterItem<Header, HeaderItem.HeaderViewHolder>() {

    override fun getLayoutId(): Int = R.layout.item_header

    override fun getItem(): Header = header

    override fun getViewHolder(view: View): HeaderViewHolder = HeaderViewHolder(view)

    class HeaderViewHolder(private val view: View): SimpleRecyclerAdapter.ViewHolderItem<Header>(view) {

        override fun bind(item: Header) {
            Picasso.get().load(item.imageUrl).into(view.image)
        }

    }
}