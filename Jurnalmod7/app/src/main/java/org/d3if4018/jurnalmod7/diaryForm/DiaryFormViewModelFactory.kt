package org.d3if4018.jurnalmod7.diaryForm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4018.jurnalmod7.Database.DiaryDatabaseDao
import org.d3if4018.jurnalmod7.diaryTracker.DiaryTrackerViewModel

class DiaryFormViewModelFactory(private val dataSource : DiaryDatabaseDao, private val application: Application): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryTrackerViewModel::class.java)) {
            return DiaryTrackerViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}