package com.slosarz.stocksearch.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.slosarz.stocksearch.R
import com.slosarz.stocksearch.repo.PictureLoader
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupPictureSearchList()
    }

    private fun setupPictureSearchList() {
        val pictureLoader by inject<PictureLoader>()
        val adapter = PictureAdapter(this, pictureLoader)
        viewModel.pictureData.observe(this, Observer { adapter.submitList(it) })
        pictureList.layoutManager = LinearLayoutManager(this)
        pictureList.adapter = adapter
    }
}
