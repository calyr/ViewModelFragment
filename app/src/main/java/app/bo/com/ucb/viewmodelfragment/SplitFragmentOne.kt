package app.bo.com.ucb.viewmodelfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class SplitFragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_split_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val totalViewModel = TotalViewModel()
        val totalViewModel = ViewModelProvider(requireActivity()).get(TotalViewModel::class.java)

        totalViewModel.counter.observe(viewLifecycleOwner, Observer(::updateText))

        view.findViewById<Button>(R.id.fragment_split_one_button).setOnClickListener {
            totalViewModel.addTotal()
        }
    }

    private fun updateText(i: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text)?.text = getString(R.string.total, i)
    }


}