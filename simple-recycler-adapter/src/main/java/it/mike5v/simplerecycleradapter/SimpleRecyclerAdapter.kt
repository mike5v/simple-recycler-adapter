package it.mike5v.simplerecycleradapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Michele Quintavalle
 */
class SimpleRecyclerAdapter : RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolderItem<Any>>() {

    val adapterItems = SparseArray<AdapterItem<Any, ViewHolderItem<Any>>>()
    private val items = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem<Any> {
        try {
            val adapterItem = getAdapterItem(viewType)
            val view = LayoutInflater.from(parent.context).inflate(
                    adapterItem?.getLayoutId()!!,
                    parent,
                    false
            )
            return adapterItem.getViewHolder(view)
        } catch (exc: Throwable) {
            throw RuntimeException("Error: No adapteritem was added for the item", exc)
        }
    }

    override fun onBindViewHolder(holder: ViewHolderItem<Any>, position: Int) = holder.bind(getItem(position))

    override fun getItemViewType(position: Int) = getItemViewType(getItem(position).javaClass)

    override fun getItemCount() = items.size

    fun getItemViewType(type: Class<*>) = type.hashCode()

    private fun getAdapterItem(viewType: Int) = adapterItems[viewType]

    private fun getItem(position: Int) = items[position]

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : Any> add(
            adapterItem: AdapterItem<T, out ViewHolderItem<T>>
    ) {
        adapterItems.put(getItemViewType(T::class.java), adapterItem as AdapterItem<Any, ViewHolderItem<Any>>)
        addItem(adapterItem.getItem())
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun addItem(item: Any) {
        items.add(item)
        notifyDataSetChanged()
    }

    abstract class AdapterItem<T, H> {
        abstract fun getLayoutId(): Int
        abstract fun getItem(): T
        abstract fun getViewHolder(view: View): H
    }

    abstract class ViewHolderItem<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: T)
    }
}
