package org.d3if4018.jurnalmod7.diaryForm

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.ui.NavigationUI

import org.d3if4018.jurnalmod7.R
import org.d3if4018.jurnalmod7.Database.Diary
import org.d3if4018.jurnalmod7.Database.DiaryDatabase
import org.d3if4018.jurnalmod7.Database.DiaryDatabaseDao
import org.d3if4018.jurnalmod7.databinding.FragmentDiaryFormBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * A simple [Fragment] subclass.
 */
class DiaryFormFragment : Fragment() {
    private lateinit var binding: FragmentDiaryFormBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_diary_form,container,false)
        val application = requireNotNull(this.activity).application
      //  val dataSource = DiaryDatabase.getInstance(application).diaryDatabaseDao
        //val viewModelFactory = DiaryFormViewModelFactory(dataSource,application)

       // val diaryFormViewModel = ViewModelProviders.of(this,viewModelFactory).get(DiaryFormViewModel::class.java)

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.check_menu,menu)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var diary = Diary()
        val application = requireNotNull(this.activity).application
        val dataSource = DiaryDatabase.getInstance(application).diaryDatabaseDao
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM  yyyy")
        val formatted = current.format(formatter)

        diary.textDiary = binding.inputNoteDiary.text.toString()
        diary.dateDiary = formatted

        when(item.itemId){
            R.id.simpan -> saveDiary(dataSource,diary,application)
        }



        return super.onOptionsItemSelected(item)
    }

    private fun saveDiary(dataSource : DiaryDatabaseDao, diary : Diary, application : Application){
        DiaryFormViewModel(dataSource,diary,application).onSave()
        binding.inputNoteDiary.text.clear()
    }

}

