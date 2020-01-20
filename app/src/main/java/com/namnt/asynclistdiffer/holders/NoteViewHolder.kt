package com.namnt.asynclistdiffer.holders

import android.os.SystemClock
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
    lateinit var title : TextView

    @BindView(R.id.imvDelete)
    lateinit var imvDelete : ImageView

    init {
        ButterKnife.bind(this, itemView)
    }
    fun bindData(note : Note, clickListener : (Int) -> Unit) {
        title.text = note.title
        var mLastClickTime : Long = 0
        imvDelete.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return
                }
                clickListener(adapterPosition)
                mLastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }

}