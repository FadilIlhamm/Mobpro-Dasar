package org.d3if4018.jurnalmod7.diaryTracker


import android.os.Bundle
import android.view.*

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import org.d3if4018.jurnalmod7.R
import org.d3if4018.jurnalmod7.Database.DiaryDatabase
import org.d3if4018.jurnalmod7.databinding.FragmentDiaryTrackerBinding

/**
 * A simple [Fragment] subclass.
 */
class DiaryTrackerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding : FragmentDiaryTrackerBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_diary_tracker,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = DiaryDatabase.getInstance(application).diaryDatabaseDao
        val viewModelFactory = DiaryTrackerViewModelFactory(dataSource,application)

        val diaryTrackerViewModel = ViewModelProviders.of(this,viewModelFactory).get(DiaryTrackerViewModel::class.java)

        binding.diaryTrackerViewModel = diaryTrackerViewModel

        binding.setLifecycleOwner(this)

        binding.btnTulis.setOnClickListener{
            it.findNavController().navigate(R.id.action_diaryTrackerFragment_to_diaryFormFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val application = requireNotNull(this.activity).application
        val dataSource = DiaryDatabase.getInstance(application).diaryDatabaseDao
        when(item.itemId){
            R.id.hapus -> DiaryTrackerViewModel(dataSource,application).onClear()
        }

        return super.onOptionsItemSelected(item)
    }

}

