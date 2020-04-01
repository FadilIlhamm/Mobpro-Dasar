package org.d3if4018.jurnalmod7.diaryForm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.fragment_diary_form.view.*
import kotlinx.coroutines.*

import org.d3if4018.jurnalmod7.Database.Diary
import org.d3if4018.jurnalmod7.Database.DiaryDatabaseDao

class DiaryFormViewModel(val database: DiaryDatabaseDao, val diary: Diary, application: Application) : AndroidViewModel(application){
    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onSave(){
        uiScope.launch {
            insert(diary)
        }
    }

    private suspend fun insert(diary : Diary){
        withContext(Dispatchers.IO){
            database.insertDiary(diary)
        }
    }

}