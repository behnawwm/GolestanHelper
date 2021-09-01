package ir.behnawwm.golestanhelper.views.main.fragments.guide

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ItemGuideBinding
import ir.behnawwm.golestanhelper.databinding.ItemList2Binding


class GuideListItem(val title: String?, val description: String?, val downloadUrl: String?) :
    AbstractBindingItem<ItemGuideBinding>() {

    override val type: Int
        get() = R.id.fastadapter_list_guide

    override fun bindView(binding: ItemGuideBinding, payloads: List<Any>) {
        val expandable = binding.expandable
        expandable.setOnClickListener {
            if (expandable.isExpanded)
                expandable.collapse()
            else
                expandable.expand()
        }
        expandable.parentLayout.findViewById<TextView>(R.id.tv_title).text = title
        expandable.secondLayout.findViewById<TextView>(R.id.tv_desc).text = description

    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemGuideBinding =
        ItemGuideBinding.inflate(inflater, parent, false)
}