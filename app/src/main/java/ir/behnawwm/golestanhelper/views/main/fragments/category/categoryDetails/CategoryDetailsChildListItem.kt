package ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ItemList3Binding
import ir.behnawwm.golestanhelper.databinding.ItemListCategoryDetailsBinding


class CategoryDetailsChildListItem(
    val item: ResultItem,
) :
    AbstractBindingItem<ItemList3Binding>() {

    override val type: Int
        get() = R.id.fastadapter_list_fragment_details_child

    override fun bindView(binding: ItemList3Binding, payloads: List<Any>) {
        binding.apply {
            tvCode.text = item.code.toString()
            tvTitle.text = item.title
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemList3Binding =
        ItemList3Binding.inflate(inflater, parent, false)
}