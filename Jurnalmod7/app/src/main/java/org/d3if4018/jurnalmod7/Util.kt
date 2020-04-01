package org.d3if4018.jurnalmod7

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import org.d3if4018.jurnalmod7.Database.Diary
import java.lang.StringBuilder

fun formatDiaries(diaries : List<Diary>, resources: Resources): Spanned{
    val sb = StringBuilder()

    sb.apply {
        diaries.forEach{
            append(resources.getString(R.string.list_diaries,it.dateDiary,it.textDiary))
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}