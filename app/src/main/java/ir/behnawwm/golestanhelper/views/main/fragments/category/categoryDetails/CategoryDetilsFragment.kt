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
import com.mikepenz.fastadapter.adapters.ItemAdapter
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryDetailsBinding

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
            val items = listOf(
                CategoryDetailsListItem("ثبت نام اصلی"),
                CategoryDetailsListItem("ثبت نام مقدماتی"),
                CategoryDetailsListItem("پرداخت خوابگاه"),
                CategoryDetailsListItem("مشاهده ریز نمرات"),
                CategoryDetailsListItem("مشاهده معدل ترم"),
            )
            val itemAdapter = ItemAdapter<CategoryDetailsListItem>()
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


        }

        return binding.root
    }
}