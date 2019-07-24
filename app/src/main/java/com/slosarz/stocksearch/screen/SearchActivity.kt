package com.slosarz.stocksearch.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.slosarz.stocksearch.R
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.viewmodel.ext.android.viewModel


class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupPictureSearchList()
    }

    private fun setupPictureSearchList() {
        val adapter = PictureAdapter(this)
        viewModel.getPictureData().observe(this, Observer { adapter.submitList(it) })
        pictureList.layoutManager = LinearLayoutManager(this)
        pictureList.adapter = adapter
    }
}
