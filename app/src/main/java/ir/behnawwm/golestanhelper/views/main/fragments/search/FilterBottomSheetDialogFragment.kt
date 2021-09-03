package ir.behnawwm.golestanhelper.views.main.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.behnawwm.golestanhelper.R

class FilterBottomSheetDialogFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


//    companion object {
//        @JvmStatic
//        fun newInstance(bundle: Bundle): OptionsBottomSheetFragment {
//            val fragment = OptionsBottomSheetFragment()
//            fragment.arguments = bundle
//            return fragment
//        }
//    }
}