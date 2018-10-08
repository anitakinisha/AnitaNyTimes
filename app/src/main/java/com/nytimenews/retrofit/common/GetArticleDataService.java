package com.nytimenews.retrofit.common;

import com.nytimenews.retrofit.model.Article;
import com.nytimenews.retrofit.model.ArticleList;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GetArticleDataService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?")
    Call<ArticleList> getArticleData(@Query("api-key") String apikey );


}