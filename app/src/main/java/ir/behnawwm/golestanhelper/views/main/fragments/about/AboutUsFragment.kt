package ir.behnawwm.golestanhelper.views.main.fragments.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.behnawwm.golestanhelper.R

import ir.behnawwm.golestanhelper.databinding.FragmentAboutUsBinding
import kotlinx.android.synthetic.main.activity_main.*


class AboutUsFragment : Fragment(R.layout.fragment_about_us) {

    lateinit var binding: FragmentAboutUsBinding

    override fun onResume() {
        super.onResume()
        requireActivity().topAppBar.title = "درباره ی ما"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(inflater)

        requireActivity().topAppBar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }

}