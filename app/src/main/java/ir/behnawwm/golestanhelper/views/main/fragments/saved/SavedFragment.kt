package ir.behnawwm.golestanhelper.views.main.fragments.saved

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.behnawwm.golestanhelper.R

import ir.behnawwm.golestanhelper.databinding.FragmentAboutUsBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSavedBinding
import kotlinx.android.synthetic.main.activity_main.*


class SavedFragment : Fragment(R.layout.fragment_saved) {

    lateinit var binding: FragmentSavedBinding

    override fun onResume() {
        super.onResume()
        requireActivity().topAppBar.title = "ذخیره شده ها"

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedBinding.inflate(inflater)


        requireActivity().topAppBar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.menu_saved).icon = resources.getDrawable(R.drawable.ic_bookmark).apply {
            setTint(
                Color.BLACK
            )
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

}