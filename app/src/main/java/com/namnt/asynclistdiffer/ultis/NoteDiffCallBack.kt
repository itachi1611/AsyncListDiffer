package com.namnt.asynclistdiffer.ultis

import androidx.recyclerview.widget.DiffUtil
import com.namnt.asynclistdiffer.models.Note

class NoteDiffCallBack : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

}