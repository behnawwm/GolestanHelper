package ir.behnawwm.golestanhelper.views.main.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentCategoryBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding

class CategoryFragment : Fragment(R.layout.fragment_category) {

    lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater)

        binding.apply {


        }

        return binding.root
    }
}