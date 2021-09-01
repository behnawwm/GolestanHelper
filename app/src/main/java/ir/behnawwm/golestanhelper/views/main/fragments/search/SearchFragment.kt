package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)


        binding.apply {
            val items = listOf(
                SearchListItem("شسیسیسشی"),
                SearchListItem("شسیشس"),
                SearchListItem("ظطزی"),
                SearchListItem("لبعتلب"),
                SearchListItem("قثدذرز"),
                )
            val itemAdapter = ItemAdapter<SearchListItem>()
            itemAdapter.add(items)
            val mainListAdapter = FastAdapter.with(itemAdapter)

            // RecyclerView Init
//        mainListAdapter = MainListAdapter(this)
            binding.recyclerView.adapter = mainListAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            val divider = DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )

            divider.setDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.horizontal_divier
                )!!
            )
            binding.recyclerView.addItemDecoration(divider)
            binding.recyclerView.setHasFixedSize(true)

        }

        return binding.root
    }
}