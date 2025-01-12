package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.Category;
import com.example.androidnewsui.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description 获取全部类别信息
 * @author FZN
 */
public class ListCategoryResult {
    String TAG = "ListCategoryResult";

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取类别信息,TYPE：List
     */
    public void get() {
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .listCategory().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Category body = response.body();
                Log.d(TAG, body.toString());
                List<Category.DataDTO.ResultDTO> result = body.getData().getResult();
                Log.d(TAG, result.toString());
                System.out.println(result);
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }
}
