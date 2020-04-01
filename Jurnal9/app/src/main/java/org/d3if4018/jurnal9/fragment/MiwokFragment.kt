package org.d3if4018.jurnal9.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.d3if4018.jurnal9.MainActivity
import org.d3if4018.jurnal9.R
import org.d3if4018.jurnal9.data.Miwok
import org.d3if4018.jurnal9.databinding.FragmentMiwokBinding
import org.d3if4018.jurnal9.recylerview.MiwokAdapter
import org.d3if4018.jurnal9.recylerview.RecyclerViewClickListener
import org.d3if4018.jurnal9.viewmodel.MiwokViewModel


@Suppress("SpellCheckingInspection")
class MiwokFragment : Fragment(),
    RecyclerViewClickListener {

    private lateinit var binding: FragmentMiwokBinding
    private lateinit var viewModel: MiwokViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        judul()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_miwok, container, false)
        binding.lifecycleOwner = this


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MiwokViewModel::class.java)
        binding.miwokVm = viewModel

        viewModel.data.observe(viewLifecycleOwner, Observer {
            val adapter = MiwokAdapter(it)
            val recyclerview = binding.rvMiwok
            recyclerview.adapter = adapter
            recyclerview.layoutManager = LinearLayoutManager(this.requireContext())

            // set listener
            adapter.listener = this
        })

        viewModel.response.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    override fun onRecyclerViewItemClicked(view: View, miwok: Miwok) {
        val bundle = bundleOf("wordlist" to miwok.wordList,
            "background" to miwok.background)
        view.findNavController().navigate(R.id.action_miwokFragment_to_wordListFragment, bundle)
    }

    private fun judul() {
        val getActivity = activity!! as MainActivity
        getActivity.supportActionBar?.title = "Miwok"
    }



}
