package org.d3if4018.jurnal9.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4018.jurnal9.MainActivity
import org.d3if4018.jurnal9.R
import org.d3if4018.jurnal9.data.WordList
import org.d3if4018.jurnal9.databinding.FragmentWordListBinding
import org.d3if4018.jurnal9.recylerview.WordListAdapter


@Suppress("SpellCheckingInspection")
class WordListFragment : Fragment() {

    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        judul()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val wordList = arguments?.getParcelableArrayList<WordList>("wordlist")
            val background = arguments?.getString("background")

            val adapter = WordListAdapter(wordList!!, background!!)
            val recyclerview = binding.rvWordList
            recyclerview.adapter = adapter
            recyclerview.layoutManager = LinearLayoutManager(this.requireContext())
        }

    }

    private fun judul() {
        val getActivity = activity!! as MainActivity
        getActivity.supportActionBar?.title = "Miwok"
    }

}
