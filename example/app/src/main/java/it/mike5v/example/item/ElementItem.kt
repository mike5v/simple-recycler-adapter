package it.mike5v.example.item

import android.view.View
import com.squareup.picasso.Picasso
import it.mike5v.example.Element
import it.mike5v.example.R
import it.mike5v.simplerecycleradapter.SimpleRecyclerAdapter
import kotlinx.android.synthetic.main.item_element.view.*

/**
 * Created by Michele Quintavalle
 */
class ElementItem(private val header: Element): SimpleRecyclerAdapter.AdapterItem<Element, ElementItem.ElementViewHolder>() {

    override fun getLayoutId(): Int = R.layout.item_element

    override fun getItem(): Element = header

    override fun getViewHolder(view: View): ElementViewHolder = ElementViewHolder(view)

    class ElementViewHolder(private val view: View): SimpleRecyclerAdapter.ViewHolderItem<Element>(view) {

        override fun bind(item: Element) {
            Picasso.get().load(item.imageUrl).into(view.image)
            view.description.text = item.description
        }

    }
}