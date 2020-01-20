package com.namnt.asynclistdiffer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.namnt.asynclistdiffer.R
import com.namnt.asynclistdiffer.holders.NoteViewHolder
import com.namnt.asynclistdiffer.models.Note
import com.namnt.asynclistdiffer.ultis.NoteDiffCallBack

class NoteAdapter (private val clickListener : (Int) -> Unit) : ListAdapter<Note, NoteViewHolder>(NoteDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(inflater.inflate(R.layout.item_note, parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindData(getItem(position), clickListener)
    }

}