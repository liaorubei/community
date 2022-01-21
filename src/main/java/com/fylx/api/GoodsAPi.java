package com.fylx.api;

import com.fylx.Result;
import com.fylx.entity.Goods;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GoodsAPi {
    @GET("/goods")
    Call<Result<List<Goods>>> list();

    @GET("/goods/{id}")
    Call<Result<Goods>> getById(@Path("id") String id);
}
