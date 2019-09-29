package com.example.mockcurious

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mockcurious.models.Bar
import kotlinx.android.synthetic.main.fragment_bar_card_list.*
import java.util.*

class BarCardListFragment: Fragment() {

    lateinit var listener: Listener

    interface Listener {
        fun onBarSelected(bar: Bar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bar_card_list, container, false)

        bar_card_list.layoutManager = LinearLayoutManager(requireActivity())

        updateUI()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_bar_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.new_bar -> {
                val bar = Bar(UUID.randomUUID())

                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    companion object {
        fun newInstance(): BarCardListFragment {

        }
    }

}