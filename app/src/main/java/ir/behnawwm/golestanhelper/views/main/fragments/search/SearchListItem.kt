package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.databinding.ItemList2Binding


class SearchListItem(val data: Request) :
    AbstractBindingItem<ItemList2Binding>() {

    override val type: Int
        get() = R.id.fastadapter_list_search

    override fun bindView(binding: ItemList2Binding, payloads: List<Any>) {
        binding.title.text = data.title
        val typeString = if (data.type == 1) "پردازش" else "گزارش"   //todo enum
        binding.tvCode.text = "$typeString ${data.code}"
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemList2Binding =
        ItemList2Binding.inflate(inflater, parent, false)
}