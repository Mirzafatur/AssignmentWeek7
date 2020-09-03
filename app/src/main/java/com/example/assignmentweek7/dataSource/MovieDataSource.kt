package com.example.assignmentweek7.dataSource

import androidx.paging.PageKeyedDataSource
import com.example.assignmentweek7.model.ResultsItem
import com.example.assignmentweek7.network.ConfigApi
import com.example.assignmentweek7.network.MovieService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource : PageKeyedDataSource<Long, ResultsItem>() {

    var api : MovieService

    init {
        api = ConfigApi.restApi()
    }

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, ResultsItem>) {
        api.getMovies("b64d761def5c00e40e6a36e0032741bf", "en-US", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                response.results?.let { callback.onResult(it, null, 2L) }
            } , {
            })

        //boleh masukin github mas ? hehe
        // di github saya mas?
        //udah d github ini ya ?
        // belum :D
        //ada account github ya mas ?
        // ada //bantu push mas,saya check d lptp saya aja
        // siap uda. nanti dikirim link nya
        // lewat android studio gabisa ya uda push nya?
        //bisa mas
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovies("b64d761def5c00e40e6a36e0032741bf", "en-US", params.key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                response.results?.let { callback.onResult(it, params.key + 1) }
            } , {
            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }


}