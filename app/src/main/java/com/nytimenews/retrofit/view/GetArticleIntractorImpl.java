package com.nytimenews.retrofit.view;

import android.util.Log;

import com.nytimenews.retrofit.model.ArticleList;
import com.nytimenews.retrofit.common.GetArticleDataService;
import com.nytimenews.retrofit.network.RetrofitInstance;
import com.nytimenews.retrofit.presenter.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetArticleIntractorImpl implements MainContract.GetArticleIntractor {

    @Override
    public void getArticleArrayList(final OnFinishedListener onFinishedListener) {

        String API_KEY = "0a0113a37eca433aab2dcfc0695b4933";

        /** Create handle for the RetrofitInstance interface*/
        GetArticleDataService service = RetrofitInstance.getRetrofitInstance().create(GetArticleDataService.class);

        /** Call the method with parameter in the interface to get the Article data*/
        Call<ArticleList> call = service.getArticleData(API_KEY);

        /**Log the URL called*/
        Log.d("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArticleList>() {
            @Override
            public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                onFinishedListener.onFinished(response.body().getArticleArrayList());

            }

            @Override
            public void onFailure(Call<ArticleList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
