package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.activity_main.*

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var binding: FragmentSearchBinding
    private val args: SearchFragmentArgs by navArgs()

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

        binding.apply {
            val items = listOf(
                SearchListItem("ثبت نام اصلی"),
                SearchListItem("ثبت نام مقدماتی"),
                SearchListItem("پرداخت خوابگاه"),
                SearchListItem("مشاهده ریز نمرات"),
                SearchListItem("مشاهده معدل ترم"),
            )
            val itemAdapter = ItemAdapter<SearchListItem>()
            itemAdapter.add(items)
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


            fabFilter.setOnClickListener {
                val action =
                    SearchFragmentDirections.actionSearchFragmentToFilterBottomSheetDialogFragment(
                        args.filteredChipData,
                        args.filteredRadioData,
                        args.filteredToggleData
                    )
                findNavController().navigate(action)

            }
        }

        return binding.root
    }

    private fun refreshListAfterFilterDialog() {
        //todo


    }

}