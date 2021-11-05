package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.BottomSheetFilterBinding

class FilterBottomSheetDialogFragment : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetFilterBinding
    private val args: FilterBottomSheetDialogFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetFilterBinding.inflate(inflater)

        updateByArgs()

        binding.apply {

            btnCloseFilter.setOnClickListener {
                dismiss()
            }
            btnOkFilter.setOnClickListener {
                val chipData = chipGroupFitler.checkedChipIds
                val radioData = radioGroupFilter.checkedRadioButtonId
                val toggleData = toggleSwitchFilter.checkedPosition

                var passingRadioData = 0
                when (radioData) {
                    R.id.radiobutton_all -> passingRadioData = RADIO_BUTTON_DEFAULT
                    R.id.radiobutton_recently -> passingRadioData = RADIO_BUTTON_RECENTLY_VISITED
                    R.id.radiobutton_saved -> passingRadioData = RADIO_BUTTON_SAVED
                }
                val action =
                    FilterBottomSheetDialogFragmentDirections.actionFilterBottomSheetDialogFragmentToSearchFragment()
                        .apply {
                            filteredChipData = chipData.toIntArray()
                            filteredRadioData = passingRadioData
                            filteredToggleData = toggleData!!
                        }
                findNavController().navigate(action)
                dismiss()
            }


        }


        return binding.root
    }

    private fun updateByArgs() {
        args.prevChipData?.forEach { chipId ->
            binding.chipGroupFitler.findViewById<Chip>(chipId).isChecked = true
        }
        when (args.prevRadioData) {
            RADIO_BUTTON_DEFAULT -> binding.radiobuttonAll.isChecked = true
            RADIO_BUTTON_RECENTLY_VISITED -> binding.radiobuttonRecently.isChecked = true
            RADIO_BUTTON_SAVED -> binding.radiobuttonSaved.isChecked = true
        }
        when (args.prevToggleData) {
            TOGGLE_SWITCH_DEFAULT -> binding.toggleSwitchFilter.setCheckedPosition(
                TOGGLE_SWITCH_DEFAULT
            )
            TOGGLE_SWITCH_PARDAZESH -> binding.toggleSwitchFilter.setCheckedPosition(
                TOGGLE_SWITCH_PARDAZESH
            )
            TOGGLE_SWITCH_GOZARESH -> binding.toggleSwitchFilter.setCheckedPosition(
                TOGGLE_SWITCH_GOZARESH
            )
        }
    }


    companion object {

        const val RADIO_BUTTON_DEFAULT = 0
        const val RADIO_BUTTON_RECENTLY_VISITED = 1
        const val RADIO_BUTTON_SAVED = 2

        const val TOGGLE_SWITCH_DEFAULT = 0
        const val TOGGLE_SWITCH_PARDAZESH = 1
        const val TOGGLE_SWITCH_GOZARESH = 2
    }


}