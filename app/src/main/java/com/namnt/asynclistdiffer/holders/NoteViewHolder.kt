package com.namnt.asynclistdiffer.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.namnt.asynclistdiffer.R
import com.namnt.asynclistdiffer.models.Note

class NoteViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    @BindView(R.id.tvTitle)
    private lateinit var title : TextView

    @BindView(R.id.imvDelete)
    private lateinit var imvDelete : ImageView

    init {
        ButterKnife.bind(this, itemView)
    }
    fun bindData(note : Note, clickListener : (Int) -> Unit) {
        title.text = note.title
        imvDelete.setOnClickListener{ clickListener(adapterPosition)}
    }

}