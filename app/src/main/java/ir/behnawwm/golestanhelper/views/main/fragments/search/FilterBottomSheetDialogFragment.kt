package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.BottomSheetFilterBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.bottom_sheet_filter.*

class FilterBottomSheetDialogFragment : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetFilterBinding.inflate(inflater)

        binding.apply {
            toggleSwitchFilter.setCheckedPosition(0)

            btnCloseFilter.setOnClickListener {
                dismiss()
            }
            btnOkFilter.setOnClickListener {
                val chipData = chipGroupFitler.checkedChipIds
                val radioData = radioGroupFilter.checkedRadioButtonId
                val toggleData = toggleSwitchFilter.checkedPosition

                Toast.makeText(requireContext(),""+chipData + radioData+toggleData,Toast.LENGTH_LONG).show()
            }

        }




        return binding.root
//        return inflater.inflate(R.layout.bottom_sheet_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}