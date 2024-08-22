package com.jgy.animal.interfaces;

import com.jgy.animal.repository.ApiFacility;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CallApi {
    // Search 기능 /////////////////////////////////////////////////////////////////////////////////

    @POST("/home/search")
    Call<ApiFacility> getSearchFacility(@Query("apiIndex") int apiIndex, @Query("query") String query);

    @GET("/home/searchIndexLength")
    Call<Integer> getSearchIndexLength(@Query("query") String query);

    ///////////////////////////////////////////////////////////////////////////////////////////////

    //카테고리별 리스트 ///////////////////////////////////////////////////////////////////////////////
    //==============================================================================================
    @POST("/home/campData")
    Call<ApiFacility> getCampFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/campIndexLength")
    Call<Integer> getCampIndexLength();

    //==============================================================================================
    @POST("/home/cultData")
    Call<ApiFacility> getCultFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/cultIndexLength")
    Call<Integer> getCultIndexLength();

    //==============================================================================================
    @POST("/home/butyData")
    Call<ApiFacility> getButyFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/butyIndexLength")
    Call<Integer> getButyIndexLength();

    //==============================================================================================
    @POST("/home/foodData")
    Call<ApiFacility> getFoodFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/foodIndexLength")
    Call<Integer> getFoodIndexLength();

    //==============================================================================================
    @POST("/home/mediData")
    Call<ApiFacility> getMediFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/mediIndexLength")
    Call<Integer> getMediIndexLength();

    //==============================================================================================
    @POST("/home/tripData")
    Call<ApiFacility> getTripFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/tripIndexLength")
    Call<Integer> getTripIndexLength();
    //==============================================================================================

    //지역별 리스트 //////////////////////////////////////////////////////////////////////////////////
    //==============================================================================================
    // 서울특별시
    @POST("/home/seoulData")
    Call<ApiFacility> getSeoulFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/seoulIndexLength")
    Call<Integer> getSeoulIndexLength();
    //==============================================================================================
    // 부산광역시
    @POST("/home/busanData")
    Call<ApiFacility> getBusanFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/busanIndexLength")
    Call<Integer> getBusanIndexLength();
    //==============================================================================================
    // 인천광역시
    @POST("/home/incheonData")
    Call<ApiFacility> getIncheonFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/incheonIndexLength")
    Call<Integer> getIncheonIndexLength();
    //==============================================================================================
    // 대구광역시
    @POST("/home/daeguData")
    Call<ApiFacility> getDaeguFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/daeguIndexLength")
    Call<Integer> getDaeguIndexLength();
    //==============================================================================================
    // 대전광역시
    @POST("/home/daejeonData")
    Call<ApiFacility> getDaejeonFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/daejeonIndexLength")
    Call<Integer> getDaejeonIndexLength();
    //==============================================================================================
    // 광주광역시
    @POST("/home/gwangjuData")
    Call<ApiFacility> getGwangjuFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/gwangjuIndexLength")
    Call<Integer> getGwangjuIndexLength();
    //==============================================================================================
    // 울산광역시
    @POST("/home/ulsanData")
    Call<ApiFacility> getUlsanFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/ulsanIndexLength")
    Call<Integer> getUlsanIndexLength();
    //==============================================================================================
    // 경기도
    @POST("/home/gyeonggiData")
    Call<ApiFacility> getGyeonggiFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/gyeonggiIndexLength")
    Call<Integer> getGyeonggiIndexLength();
    //==============================================================================================
    // 경상도
    @POST("/home/gyeongsangData")
    Call<ApiFacility> getGyeongsangFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/gyeongsangIndexLength")
    Call<Integer> getGyeongsangIndexLength();
    //==============================================================================================
    // 전라도
    @POST("/home/jeonllaData")
    Call<ApiFacility> getJeonllaFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/jeonllaIndexLength")
    Call<Integer> getJeonllaIndexLength();
    //==============================================================================================
    // 충청도
    @POST("/home/chungcheongData")
    Call<ApiFacility> getChungcheongFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/chungcheongIndexLength")
    Call<Integer> getChungcheongIndexLength();
    //==============================================================================================
    // 강원도
    @POST("/home/gangwonData")
    Call<ApiFacility> getGangwonFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/gangwonIndexLength")
    Call<Integer> getGangwonIndexLength();
    //==============================================================================================
    // 세종특별자치시
    @POST("/home/sejongData")
    Call<ApiFacility> getSejongFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/sejongIndexLength")
    Call<Integer> getSejongIndexLength();
    //==============================================================================================
    // 제주특별자치도
    @POST("/home/jejuData")
    Call<ApiFacility> getJejuFacility(@Query("apiIndex") int apiIndex);

    @GET("/home/jejuIndexLength")
    Call<Integer> getJejuIndexLength();
    //==============================================================================================

}
