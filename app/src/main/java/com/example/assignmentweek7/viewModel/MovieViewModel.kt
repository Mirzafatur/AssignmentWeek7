package com.example.assignmentweek7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.assignmentweek7.dataSource.factory.MovieDataFactory
import com.example.assignmentweek7.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MovieViewModel : ViewModel() {

    var executor : Executor
    var resultData : LiveData<PagedList<ResultsItem>>

    init {

        executor = Executors.newFixedThreadPool(5)

        var movieFactory = MovieDataFactory()

        var pagedListConfiguration = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(false)
            .build()

        resultData = LivePagedListBuilder(movieFactory, pagedListConfiguration)
            .setFetchExecutor(executor)
            .build()
    }

    fun getResult() : LiveData<PagedList<ResultsItem>> {
        return resultData
    }

}