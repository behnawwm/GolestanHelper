package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.databinding.ItemList3Binding

class SearchListItem(
    val data: Request,
    val makeItemBookmarklivedata : MutableLiveData<Request>
) :
    AbstractBindingItem<ItemList3Binding>() {

    override val type: Int
        get() = R.id.fastadapter_list_search

    override fun bindView(binding: ItemList3Binding, payloads: List<Any>) {
        binding.apply {
            val typeString = if (data.type == 1) "پردازش" else "گزارش"   //todo enum
            tvTitle.text = data.title
            tvCode.text = "$typeString ${data.code}"
            tvDate.text = "آخرین بازدید : هیچوقت"    //todo

            if(data.isFavorite)
                btnBookmark.setBackgroundResource(R.drawable.ic_bookmark)
            else
                btnBookmark.setBackgroundResource(R.drawable.ic_bookmark_border)


            btnBookmark.setOnClickListener {
                if (data.isFavorite) {
                    btnBookmark.setBackgroundResource(R.drawable.ic_bookmark_border)
                    makeItemBookmarklivedata.postValue(data.copy(isFavorite = !data.isFavorite))
                } else {
                    btnBookmark.setBackgroundResource(R.drawable.ic_bookmark)
                    makeItemBookmarklivedata.postValue(data.copy(isFavorite = !data.isFavorite))
                }

            }
        }

    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemList3Binding =
        ItemList3Binding.inflate(inflater, parent, false)
}