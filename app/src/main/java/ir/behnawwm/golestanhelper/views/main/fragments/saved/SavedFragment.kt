package ir.behnawwm.golestanhelper.views.main.fragments.saved

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.data.CachingRepo
import ir.behnawwm.golestanhelper.data.database.entity.Request

import ir.behnawwm.golestanhelper.databinding.FragmentAboutUsBinding
import ir.behnawwm.golestanhelper.databinding.FragmentSavedBinding
import ir.behnawwm.golestanhelper.views.main.fragments.search.SearchListItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SavedFragment : Fragment(R.layout.fragment_saved) {

    lateinit var binding: FragmentSavedBinding
    private lateinit var listItems: List<SearchListItem>
    private lateinit var itemAdapter: ItemAdapter<SearchListItem>
    private val makeItemBookmarklivedata = MutableLiveData<Request>()

    @Inject
    lateinit var repo: CachingRepo

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

        makeItemBookmarklivedata.observe(viewLifecycleOwner){

        }

        itemAdapter = ItemAdapter()
        lifecycleScope.launch {
            val items = repo.getAllDataFromDb()
            listItems = items.map {
                SearchListItem(it, makeItemBookmarklivedata)
            }.filter {
                it.data.isFavorite
            }
            itemAdapter.set(listItems)
        }
        val mainListAdapter = FastAdapter.with(itemAdapter)

        // RecyclerView Init5
        binding.recyclerView.adapter = mainListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


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