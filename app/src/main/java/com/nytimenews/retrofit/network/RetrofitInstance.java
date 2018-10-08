package com.nytimenews.retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;;
   private static final String API_KEY = "0a0113a37eca433aab2dcfc0695b4933";

   private static final String BASE_URL = "http://api.nytimes.com/"; //svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=0a0113a37eca433aab2dcfc0695b4933";


    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}