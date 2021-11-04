package ir.behnawwm.golestanhelper.views.main.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryBinding
import ir.behnawwm.golestanhelper.views.main.fragments.guide.GuideListItem

class CategoryFragment : Fragment(R.layout.fragment_category) {

    lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater)

        binding.apply {
            frameLayoutAmoozesh.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(1)
                findNavController().navigate(action)
            }
            frameLayoutSabtenam.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(2)
                findNavController().navigate(action)
            }
            frameLayoutDaneshjooyi.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(3)
                findNavController().navigate(action)
            }
            frameLayoutMali.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(4)
                findNavController().navigate(action)
            }
            framelayoutArzeshyabi.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(5)
                findNavController().navigate(action)
            }

            frameLayoutPishkhan.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(6)
                findNavController().navigate(action)
            }
            frameLayoutSabtenam.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(7)
                findNavController().navigate(action)
            }



        }

        return binding.root
    }
}