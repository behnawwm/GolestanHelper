package ir.behnawwm.golestanhelper.views.main.fragments.category.categoryDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
import kotlinx.android.synthetic.main.activity_main.*


class CategoryDetailsFragment : Fragment(R.layout.fragment_category_details) {

    lateinit var binding: FragmentCategoryDetailsBinding
    val args: CategoryDetailsFragmentArgs by navArgs()
    lateinit var currentItems: List<CategoryDetailsListItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryDetailsBinding.inflate(inflater)


        requireActivity().topAppBar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val selectedCategoryId = args.selectedCategory

        binding.apply {
            currentItems = when (selectedCategoryId) {
                CategoryFragment.CATEGORY_AMOOZESH -> CategoryData.provideAmoozeshItems()
                CategoryFragment.CATEGORY_SABTENAM -> CategoryData.provideSabtenamItems()
                CategoryFragment.CATEGORY_DANESHJOOYI -> CategoryData.provideDaneshjooyiItems()
                CategoryFragment.CATEGORY_MALI -> CategoryData.provideMaliItems()
                CategoryFragment.CATEGORY_ARZESHYABI -> CategoryData.provideArzeshyabiItems()
                CategoryFragment.CATEGORY_PISHKHAN -> CategoryData.providePishkhanItems()
                CategoryFragment.CATEGORY_SYSTEM -> CategoryData.provideSystemItems()
                else -> emptyList()
            }

            val itemAdapter = ItemAdapter<CategoryDetailsListItem>()
            val mainListAdapter = FastAdapter.with(itemAdapter)
            initRecyclerView(mainListAdapter)

            val mappedItems = currentItems.map {
                CategoryDetailsListItem(it.name, it.parentItems,it.childItems)
            }
            itemAdapter.set(mappedItems)
            mainListAdapter.onClickListener =
                { v: View?, _: IAdapter<CategoryDetailsListItem>, item: CategoryDetailsListItem, _: Int ->
                    if (v != null) {
                        if (item.parentItems == null) {
                            //todo set child items for showing codes!
                            Toast.makeText(requireContext(), "residim!", Toast.LENGTH_SHORT).show()
                            initRecyclerView2(item.childItems!!)
                        } else
                            itemAdapter.set(item.parentItems)
                    }
                    false
                }

        }

        return binding.root
    }

    private fun initRecyclerView2(childItems: List<ResultItem>) {
        val itemAdapter2 = ItemAdapter<CategoryDetailsChildListItem>()
        itemAdapter2.set(childItems!!.map {
            CategoryDetailsChildListItem(it)
        })
        val mainListAdapter2 = FastAdapter.with(itemAdapter2)
        binding.recyclerView2.adapter = mainListAdapter2
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView2.setHasFixedSize(true)
        binding.recyclerView2.isVisible = true
        binding.recyclerView.isVisible = false
    }


    private fun initRecyclerView(
        mainListAdapter: FastAdapter<CategoryDetailsListItem>,
    ) {
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
    }
}