package org.d3if4018.jurnalmod7.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DiaryDatabaseDao {

    @Insert
    fun insertDiary(diary : Diary)

    @Update
    fun updateDiary(diary : Diary)

    @Query("SELECT * FROM daily_diary WHERE diaryId = :key")
    fun get(key: Long) : Diary

    @Query("DELETE FROM daily_diary")
    fun clear()

    @Query("SELECT * FROM daily_diary ORDER BY diaryId DESC")
    fun getAllDiary(): LiveData<List<Diary>>

    @Query("SELECT * FROM daily_diary ORDER BY diaryId DESC LIMIT 1")
    fun getDiary(): Diary?

}