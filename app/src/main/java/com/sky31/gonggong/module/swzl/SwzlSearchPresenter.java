package com.sky31.gonggong.module.swzl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sky31.gonggong.config.Constants;
import com.sky31.gonggong.model.SwzlSearchResult;
import com.sky31.gonggong.model.SwzlService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by wukunguang on 16-3-17.
 */
public class SwzlSearchPresenter {


    private SwzlSearchView searchView;
    private SwzlService service;
    private Context context;

    public SwzlSearchPresenter(SwzlSearchView searchView,Context context) {
        this.searchView = searchView;
        this.context = context;
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(Constants.Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(SwzlService.class);

    }
    /***
     *
     * @param actionCode 0 is lost,1 is get/found
     *
     */
    public void getSearchResult(int actionCode){


        Call<SwzlSearchResult> resultCall;
        if (actionCode==0) {
            Log.d("action:",actionCode+"");
            resultCall = service.getSerResultByLost();
        }
        else {
            Log.d("action:",actionCode+"");
            resultCall = service.getSerResultByGet();
        }

        resultCall.enqueue(new Callback<SwzlSearchResult>() {
            @Override
            public void onResponse(Response<SwzlSearchResult> response, Retrofit retrofit) {

                SwzlSearchResult result;
                result = response.body();
                int code = Integer.parseInt(response.body().getCode());
                // 回调函数传入参数
                searchView.getSearchData(code,result);
            }

            @Override
            public void onFailure(Throwable t) {


                t.printStackTrace();
                searchView.getSearchData(-1, null);
            }
        });





    }


    public void doSearchByKey(String key){

        Call<SwzlSearchResult> call = service.getSearchResult(key);

        call.enqueue(new Callback<SwzlSearchResult>() {
            @Override
            public void onResponse(Response<SwzlSearchResult> response, Retrofit retrofit) {
                if (response.body().getCode().equals("0")){

                    int code = Integer.parseInt(response.body().getCode());
                    searchView.getSearchData(code , response.body());

                }
                else {
                    int code = Integer.parseInt(response.body().getCode());
                    searchView.getSearchData(code,null);
                }
            }

            @Override
            public void onFailure(Throwable t) {

                t.printStackTrace();
                Toast.makeText(context,"网络请求出错，请稍后再试",Toast.LENGTH_SHORT).show();

            }
        });
    }

}
