package com.sky31.gonggong.model;

import com.sky31.gonggong.config.Constants;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by wukunguang on 16-3-1.
 */
public interface SwzlService {

    String defaultParm = "&role="+Constants.Value.ROLE+"&hash="+Constants.Value.HASH+"&cache=OFF";
    String submitLostParm = "ask_method="+Constants.Value.SWZL_ASK_METHOD_JSON+"&"+"action="+Constants.Value.SWZL_SUBMIT_LOST+defaultParm;
    String submitGetParm = "ask_method="+Constants.Value.SWZL_ASK_METHOD_JSON+"&"+"action="+Constants.Value.SWZL_SUBMIT_FOUND+defaultParm;

    String search_lost_thing = "ask_method="+Constants.Value.SWZL_ASK_METHOD_JSON+"&action="+Constants.Value.SWZL_SEARCH_LOST+defaultParm;
    String search_get_thing = "ask_method="+Constants.Value.SWZL_ASK_METHOD_JSON+"&action="+Constants.Value.SWZL_SEARCH_FOUND+defaultParm;
    String search = "ask_method="+Constants.Value.SWZL_ASK_METHOD_JSON+"&action="+Constants.Value.SWZL_SEARCH+defaultParm;

    @GET(Constants.Api.SWZL_ACTION+"?"+search_get_thing)
    Call<SwzlSearchResult> getSerResultByGet( );



    @GET(Constants.Api.SWZL_ACTION+"?"+search_lost_thing)
    Call<SwzlSearchResult> getSerResultByLost( );

    @FormUrlEncoded
    @POST(Constants.Api.SWZL_ACTION+"?"+submitLostParm)
    Call<SwzlResModel> getSubResultByLost(@FieldMap Map<String,String> map);


    @FormUrlEncoded
    @POST(Constants.Api.SWZL_ACTION+"?"+submitGetParm)
    Call<SwzlResModel> getSubResultByGet(@FieldMap  Map<String,String> map);


    @GET(Constants.Api.SWZL_ACTION+"?"+search)
    Call<SwzlSearchResult> getSearchResult(@Query("key") String key);



}
