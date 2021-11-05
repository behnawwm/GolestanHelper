package ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.CategoryData
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryDetailsBinding
import ir.behnawwm.golestanhelper.views.main.fragments.category.CategoryFragment

class CategoryDetilsFragment : Fragment(R.layout.fragment_category_details) {

    lateinit var binding: FragmentCategoryDetailsBinding
    val args: CategoryDetilsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryDetailsBinding.inflate(inflater)

        val selectedCategoryId = args.selectedCategory

        binding.apply {
            val items = when (selectedCategoryId) {
                CategoryFragment.CATEGORY_AMOOZESH -> CategoryData.provideAmoozeshItems()
                CategoryFragment.CATEGORY_SABTENAM -> CategoryData.provideSabtenamItems()
                CategoryFragment.CATEGORY_DANESHJOOYI -> CategoryData.provideDaneshjooyiItems()
                CategoryFragment.CATEGORY_MALI -> CategoryData.provideMaliItems()
                CategoryFragment.CATEGORY_ARZESHYABI -> CategoryData.provideArzeshyabiItems()
                CategoryFragment.CATEGORY_PISHKHAN -> CategoryData.providePishkhanItems()
                CategoryFragment.CATEGORY_SYSTEM -> CategoryData.provideSystemItems()
                else -> null
            }
            val itemAdapter = ItemAdapter<CategoryDetailsListItem>()
            itemAdapter.add(items!!)
            val mainListAdapter = FastAdapter.with(itemAdapter)

            // RecyclerView Init
            binding.recyclerView.adapter = mainListAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            val divider = DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )

            divider.setDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.horizontal_divider
                )!!
            )
            binding.recyclerView.addItemDecoration(divider)
            binding.recyclerView.setHasFixedSize(true)

            mainListAdapter.onClickListener =
                { v: View?, _: IAdapter<CategoryDetailsListItem>, item: CategoryDetailsListItem, _: Int ->
                    if (v != null) {
                        if (item.parentItem == null) {
//                            itemAdapter.set(item.childItem!!)    //todo set child items for showing codes!
                        }
                        else
                            itemAdapter.set(item.parentItem)
                    }
                    false
                }
        }

        return binding.root
    }
}