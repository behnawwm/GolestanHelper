package ir.behnawwm.golestanhelper.views.main.fragments.guide

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
import ir.behnawwm.golestanhelper.databinding.FragmentGuideBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding

class GuideFragment : Fragment(R.layout.fragment_guide) {

    lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuideBinding.inflate(inflater)


        binding.apply {
            val items = listOf(
                GuideListItem(
                    "ثبت نام مقدماتی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت نام مقدماتی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت نام مقدماتی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت نام مقدماتی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت نام مقدماتی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت ی",
                    resources.getString(R.string.sample_guide_desc),
                    null
                ),
                GuideListItem(
                    "ثبت نام مقدماتی",
                    "تست",
                    null
                ),

                )
            val itemAdapter = ItemAdapter<GuideListItem>()
            itemAdapter.add(items)
            val mainListAdapter = FastAdapter.with(itemAdapter)

            // RecyclerView Init
            binding.rvCategory.adapter = mainListAdapter
            binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
            binding.rvCategory.setHasFixedSize(true)


        }

        return binding.root
    }
}