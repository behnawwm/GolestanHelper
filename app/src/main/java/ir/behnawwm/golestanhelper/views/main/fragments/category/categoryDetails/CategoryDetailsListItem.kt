package ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ItemListCategoryDetailsBinding


class CategoryDetailsListItem(
    val name: String?,
    val parentItem: List<CategoryDetailsListItem>?,
    val childItem : List<ResultItem>?
) :
    AbstractBindingItem<ItemListCategoryDetailsBinding>() {

    override val type: Int
        get() = R.id.fastadapter_list_fragment_details

    override fun bindView(binding: ItemListCategoryDetailsBinding, payloads: List<Any>) {
        binding.title.text = name
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemListCategoryDetailsBinding =
        ItemListCategoryDetailsBinding.inflate(inflater, parent, false)
}