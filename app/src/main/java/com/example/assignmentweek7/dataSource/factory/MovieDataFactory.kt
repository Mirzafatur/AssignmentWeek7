package com.example.assignmentweek7.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.assignmentweek7.dataSource.MovieDataSource
import com.example.assignmentweek7.model.ResultsItem

class MovieDataFactory : DataSource.Factory<Long, ResultsItem>(){

    var mutableLiveData : MutableLiveData<MovieDataSource>
    var movieDataSource : MovieDataSource

    init {

        mutableLiveData = MutableLiveData()
       movieDataSource = MovieDataSource()
        //sbntr mas
        // siap uda

    }

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

    fun getLiveData() : MutableLiveData<MovieDataSource> {
        return mutableLiveData
    }

}