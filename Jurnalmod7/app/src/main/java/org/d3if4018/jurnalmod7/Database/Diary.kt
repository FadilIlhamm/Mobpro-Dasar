package org.d3if4018.jurnalmod7.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_diary")
data class Diary(

    @PrimaryKey(autoGenerate = true)
    var diaryId: Long = 0L,

    @ColumnInfo(name = "date_diary")
    var dateDiary: String = "",

    @ColumnInfo(name = "text_diary")
    var textDiary: String = ""

)