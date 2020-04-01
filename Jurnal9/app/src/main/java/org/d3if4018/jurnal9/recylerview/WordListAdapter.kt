package org.d3if4018.jurnal9.recylerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if4018.jurnal9.R
import org.d3if4018.jurnal9.data.WordList
import org.d3if4018.jurnal9.databinding.RecyclerviewWordlistBinding


class WordListAdapter(
    private val wordList: List<WordList>,
    private val background: String
) : RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {

    inner class WordListViewHolder(
        val recyclerviewWordlistBinding: RecyclerviewWordlistBinding
    ) : RecyclerView.ViewHolder(recyclerviewWordlistBinding.root)

    override fun getItemCount() = wordList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordListViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_wordlist, parent, false)
    )

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        holder.recyclerviewWordlistBinding.listWordList.setBackgroundColor(Color.parseColor(background))
        holder.recyclerviewWordlistBinding.tvInggris.text = wordList[position].defaultWord
        holder.recyclerviewWordlistBinding.tvMiwok.text = wordList[position].miwokWord

        // image
        if (wordList[position].image == null) {
            Glide.with(holder.itemView.context).clear(holder.recyclerviewWordlistBinding.image)
            holder.recyclerviewWordlistBinding.image.setImageDrawable(null)
            holder.recyclerviewWordlistBinding.image.visibility = View.GONE
        } else {
            Glide.with(holder.itemView.context)
                .load("http://dif.indraazimi.com/miwok/${wordList[position].image}")
                .placeholder(R.drawable.ic_launcher_foreground)
                .dontAnimate()
                .into(holder.recyclerviewWordlistBinding.image)
        }
    }
}