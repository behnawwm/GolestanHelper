package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ItemList2Binding


class SearchListItem(val name: String?, val code: Int) : AbstractBindingItem<ItemList2Binding>() {

    override val type: Int
        get() = R.id.fastadapter_list_search

    override fun bindView(binding: ItemList2Binding, payloads: List<Any>) {
        binding.title.text = name
        binding.tvCode.text = code.toString()
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemList2Binding =
        ItemList2Binding.inflate(inflater, parent, false)
}