package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.dsl.itemAdapter
import com.mikepenz.fastadapter.listeners.ItemFilterListener
import dagger.hilt.android.AndroidEntryPoint
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.CachingRepo
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var binding: FragmentSearchBinding
    private val args: SearchFragmentArgs by navArgs()
    private lateinit var itemAdapter: ItemAdapter<SearchListItem>
    private lateinit var mainListAdapter: FastAdapter<SearchListItem>
    private lateinit var listItems: List<SearchListItem>
    private val makeItemBookmarklivedata = MutableLiveData<Request>()

    @Inject
    lateinit var cachingRepo: CachingRepo

    override fun onResume() {
        super.onResume()

        requireActivity().topAppBar.navigationIcon = null
        requireActivity().topAppBar.title = "جستجو سریع"
        refreshListAfterFilterDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)

        makeItemBookmarklivedata.observe(viewLifecycleOwner) {  //mvvm
            lifecycleScope.launch {
                cachingRepo.insertRequest(it)

            }
        }

        binding.apply {
            setupItemAdapter()
            lifecycleScope.launch {
                val items = cachingRepo.getAllDataFromDb()
                listItems = items.map {
                    SearchListItem(it, makeItemBookmarklivedata)
                }
                itemAdapter.set(listItems)
            }
            mainListAdapter = FastAdapter.with(itemAdapter)

            // RecyclerView Init5
            binding.recyclerView.adapter = mainListAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
//            val divider = DividerItemDecoration(
//                requireContext(),
//                DividerItemDecoration.VERTICAL
//            )
//            divider.setDrawable(
//                ContextCompat.getDrawable(
//                    requireContext(),
////                    R.drawable.horizontal_divider
////                )!!
////            )
////            binding.recyclerView.addItemDecoration(divider)
            binding.recyclerView.setHasFixedSize(true)

            fabFilter.setOnClickListener {
                val action =
                    SearchFragmentDirections.actionSearchFragmentToFilterBottomSheetDialogFragment(
                        args.filteredChipData,
                        args.filteredRadioData,
                        args.filteredToggleData
                    )
                findNavController().navigate(action)

            }
            etSearch.addTextChangedListener {
                itemAdapter.filter(it)
                savedInstanceState?.putString(
                    "search_text",
                    it.toString()
                )   //todo restore searched text after filter
            }
        }

        return binding.root
    }

    private fun setupItemAdapter() {
        itemAdapter = ItemAdapter()
        setupItemAdapterFilterSetting()
    }

    private fun setupItemAdapterFilterSetting() {
        itemAdapter.itemFilter.filterPredicate =
            { item: SearchListItem, constraint: CharSequence? ->
                if (constraint != null)
                    item.data.title.contains(constraint)
                else
                    true
            }
    }

    private fun refreshListAfterFilterDialog() {
        lifecycleScope.launch {
            val items = cachingRepo.getAllDataFromDb()
            listItems = items.map {
                SearchListItem(it, makeItemBookmarklivedata)
            }.filter {
                if (args.filteredToggleData != 0)
                    return@filter it.data.type == args.filteredToggleData
                true
            }
            itemAdapter.set(listItems)
        }

    }

}