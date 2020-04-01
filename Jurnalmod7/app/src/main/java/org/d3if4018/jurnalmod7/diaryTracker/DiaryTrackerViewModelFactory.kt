package org.d3if4018.jurnalmod7.diaryTracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4018.jurnalmod7.Database.DiaryDatabaseDao

class DiaryTrackerViewModelFactory(private val dataSource : DiaryDatabaseDao, private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryTrackerViewModel::class.java)) {
            return DiaryTrackerViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}