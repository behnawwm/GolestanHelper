package ir.behnawwm.golestanhelper.views.main.fragments.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.FragmentFaqBinding
import kotlinx.android.synthetic.main.activity_main.*


class FaqFragment : Fragment(R.layout.fragment_faq) {

    lateinit var binding: FragmentFaqBinding

    override fun onResume() {
        super.onResume()
        requireActivity().topAppBar.title = "پرسش های متداول"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFaqBinding.inflate(inflater)

        requireActivity().topAppBar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }

}