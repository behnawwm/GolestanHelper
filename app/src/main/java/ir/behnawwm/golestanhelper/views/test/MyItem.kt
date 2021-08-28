package ir.behnawwm.golestanhelper.views.test

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
import ir.behnawwm.golestanhelper.databinding.IconItemBinding


class IconItem : AbstractBindingItem<IconItemBinding>() {
    var name: String? = null

    override val type: Int
        get() = R.id.fastadapter_sample_item_id2

    override fun bindView(binding: IconItemBinding, payloads: List<Any>) {
        binding.name.text = name
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): IconItemBinding =
        IconItemBinding.inflate(inflater, parent, false)
}