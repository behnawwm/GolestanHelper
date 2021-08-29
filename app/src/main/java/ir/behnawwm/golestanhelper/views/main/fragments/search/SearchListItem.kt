package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.items.AbstractItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ItemList2Binding


class SearchListItem(val name: String?) : AbstractBindingItem<ItemList2Binding>() {

    override val type: Int
        get() = R.id.fastadapter_sample_item_id2

    override fun bindView(binding: ItemList2Binding, payloads: List<Any>) {
        binding.title.text = name
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemList2Binding =
        ItemList2Binding.inflate(inflater, parent, false)
}