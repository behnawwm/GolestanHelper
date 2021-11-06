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
import kotlinx.android.synthetic.main.activity_main.*

class CategoryFragment : Fragment(R.layout.fragment_category) {

    lateinit var binding: FragmentCategoryBinding

    companion object{
        const val CATEGORY_AMOOZESH = 1
        const val CATEGORY_SABTENAM = 2
        const val CATEGORY_DANESHJOOYI = 3
        const val CATEGORY_MALI = 4
        const val CATEGORY_ARZESHYABI = 5
        const val CATEGORY_PISHKHAN = 6
        const val CATEGORY_SYSTEM = 7
    }

    override fun onResume() {
        super.onResume()
        requireActivity().topAppBar.navigationIcon = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater)

        binding.apply {
            frameLayoutAmoozesh.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_AMOOZESH)
                findNavController().navigate(action)
            }
            frameLayoutSabtenam.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_SABTENAM)
                findNavController().navigate(action)
            }
            frameLayoutDaneshjooyi.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_DANESHJOOYI)
                findNavController().navigate(action)
            }
            frameLayoutMali.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_MALI)
                findNavController().navigate(action)
            }
            framelayoutArzeshyabi.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_ARZESHYABI)
                findNavController().navigate(action)
            }

            frameLayoutPishkhan.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_PISHKHAN)
                findNavController().navigate(action)
            }
            frameLayoutSabtenam.setOnClickListener {
                val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetilsFragment(CATEGORY_SYSTEM)
                findNavController().navigate(action)
            }


        }

        return binding.root
    }
}