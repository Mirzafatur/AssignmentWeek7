package com.example.assignmentweek7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentweek7.adapter.MovieAdapter
import com.example.assignmentweek7.model.ResultsItem
import com.example.assignmentweek7.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel : MovieViewModel? = null
    private lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel?.getResult()
        adapter = MovieAdapter()


        viewModel?.getResult()?.observe(this, Observer {
         //   adapter.submitList(it)
            showData(it)



            //belum set ke recycelerview nya mas ?
            // kalau di situ jadi no adapter uda kemarin
        })
    }

    private fun showData(it: PagedList<ResultsItem>?) {
        adapter.submitList(it)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.setHasFixedSize(true)

    }

}