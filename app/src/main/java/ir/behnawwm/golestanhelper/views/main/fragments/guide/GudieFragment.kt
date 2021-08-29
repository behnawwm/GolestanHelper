package ir.behnawwm.golestanhelper.views.main.fragments.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentGuideBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding

class GudieFragment : Fragment(R.layout.fragment_guide) {

    lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuideBinding.inflate(inflater)

        binding.apply {


        }

        return binding.root
    }
}