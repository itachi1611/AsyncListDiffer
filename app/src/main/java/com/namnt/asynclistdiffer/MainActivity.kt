package com.namnt.asynclistdiffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.BindView
import butterknife.ButterKnife
import com.namnt.asynclistdiffer.adapters.NoteAdapter
import com.namnt.asynclistdiffer.sample_data.NoteDataInit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mNotes = NoteDataInit()

    var dataList = mNotes.instanceData

    private var noteAdapter = NoteAdapter{position : Int -> deleteNote(position)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        noteAdapter.submitList(dataList)
        rcvNote.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun initViews() {
        btn_forward.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    private fun onInitDataRecyclerView(state : Int){
        if(state == 1){
            Toast.makeText(this, "Forward", Toast.LENGTH_SHORT).show()
            dataList = mNotes.dataUpdate
            noteAdapter.submitList(dataList)
        } else if(state == 2){
            Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()
            dataList = mNotes.instanceData
            noteAdapter.submitList(dataList)
        }
    }
    
    private fun deleteNote(position: Int){
        dataList.removeAt(position)
        noteAdapter.notifyItemRemoved(position)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_forward -> onInitDataRecyclerView(1)
            R.id.btn_back -> onInitDataRecyclerView(2)
            else -> Toast.makeText(this, "Nothing happened !", Toast.LENGTH_SHORT).show()
        }
    }
}
