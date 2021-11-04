package ir.behnawwm.golestanhelper.views.main.fragments.category

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
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryBinding
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryDetailsBinding
import ir.behnawwm.golestanhelper.views.main.fragments.guide.GuideListItem

class CategoryDetilsFragment : Fragment(R.layout.fragment_category_details) {

    lateinit var binding: FragmentCategoryDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryDetailsBinding.inflate(inflater)



        return binding.root
    }
}