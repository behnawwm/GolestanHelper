package ir.behnawwm.golestanhelper.views.test

import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.ClickListener
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import ir.behnawwm.golestanhelper.R
import ir.behnawwm.golestanhelper.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set the items to your ItemAdapter
        val items = ArrayList<IconItem>()
        for (i in 1..10) {
            var item = IconItem()
            if (i % 2 == 0)
                item.name = i.toString()
            else
                item.name = "abc"

            items.add(item)
        }

        val itemAdapter = ItemAdapter<IconItem>()
        itemAdapter.add(items)
        val fastAdapter = FastAdapter.with(itemAdapter)

        binding.recyclerView.setBackgroundColor(resources.getColor(R.color.colorAccent))
        binding.recyclerView.adapter = fastAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        //////////

        fastAdapter.onClickListener = { view, adapter, item, position ->
            // Handle click here
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()

            true
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                itemAdapter.filter(newText)
                itemAdapter.itemFilter.filterPredicate =
                    { item: IconItem, constraint: CharSequence? ->
                        item.name?.contains(constraint.toString(), ignoreCase = true)!!
                    }

                return true
            }

        })


    }
}