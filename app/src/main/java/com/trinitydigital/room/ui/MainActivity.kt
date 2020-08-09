package com.trinitydigital.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.trinitydigital.room.MyApp
import com.trinitydigital.room.R
import com.trinitydigital.room.data.AppDataBase
import com.trinitydigital.room.data.EtData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemRvListener {

    private var db: AppDataBase? = null
    var adapter: RvAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = MyApp.app?.getDB()
        setupListeners()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val manager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = manager
        adapter = RvAdapter(this)
        recyclerView.adapter = adapter
        updateAdapter()
    }

    private fun setupListeners() {
        btnSave.setOnClickListener {
            val data = fetchData()
            db?.getDao()?.insertEtData(data)
            updateAdapter()
        }
    }

    private fun fetchData(): EtData {
        return EtData(
            etFour = etOne.text.toString(),
            etTwo = etTwo.text.toString(),
            etThree = etThree.text.toString(),
            etOne = etFour.text.toString()
        )
    }

    private fun updateAdapter() {
        val newData = db?.getDao()?.getAllEtData()
        if (newData != null)
            adapter?.update(newData)
    }

    override fun btnDeleteClicked(data: EtData) {
        db?.getDao()?.delete(data)
        updateAdapter()
    }
}