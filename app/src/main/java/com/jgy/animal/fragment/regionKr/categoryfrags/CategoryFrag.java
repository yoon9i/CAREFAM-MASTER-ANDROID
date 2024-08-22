package com.jgy.animal.fragment.regionKr.categoryfrags;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jgy.animal.Adapter.CustomAdapter;
import com.jgy.animal.Adapter.ViewItemData;
import com.jgy.animal.R;
import com.jgy.animal.activities.ButtonActivity;
import com.jgy.animal.interfaces.CallApi;
import com.jgy.animal.repository.ApiFacility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryFrag extends Fragment {
    public final static String KEY_INPUT_SCREEN = "INPUT_SCREEN";

    // 리사이클러뷰 작업
    RecyclerView recyclerView = null;
    CustomAdapter customAdapter = null;
    //ArrayList<ViewItemData> mList = new ArrayList<>();
    /////////////////////////////////////////////////////

    // 서버연결작업 //////////////////////////////////////
    private int mCategory = 0;

    // api 길이
    int apiLength;
    int loadedApiLength;

    private ProgressBar progressBar; // 작업진행상태표시

    Call<Integer> indexLengthCall;

    Call<ApiFacility> callApiFacility;
    RecyclerView.OnScrollListener scrollListener;

    private CallApi apiService;
    /////////////////////////////////////////////////////

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        View categoryView = inflater.inflate(R.layout.recycler_view, container, false);

        // 서버 연결 작업 //////////////////////////////////////////////////////////////////////

        progressBar = categoryView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        // Retrofit 인스턴스 생성
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.15:8080") // 서버의 기본 URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Retrofit 을 사용하여 API 인터페이스와 연결
        apiService = retrofit.create(CallApi.class);

        Bundle args = getArguments();
        if(args == null){
            args = new Bundle();
        }
        mCategory = args.getInt(KEY_INPUT_SCREEN, R.id.btn_camp);

        // 데이터 넣기
        switch (mCategory) {
            // 지역버튼들
            case R.id.btn_seoul: //서울광역시
                indexLengthCall = apiService.getSeoulIndexLength();
                break;
            case R.id.btn_busan: //부산광역시
                indexLengthCall = apiService.getBusanIndexLength();
                break;
            case R.id.btn_incheon: //인천광역시
                indexLengthCall = apiService.getIncheonIndexLength();
                break;
            case R.id.btn_daegu: //대구광역시
                indexLengthCall = apiService.getDaeguIndexLength();
                break;
            case R.id.btn_daejeon: //대전광역시
                indexLengthCall = apiService.getDaejeonIndexLength();
                break;
            case R.id.btn_gwangju: //광주광역시
                indexLengthCall = apiService.getGwangjuIndexLength();
                break;
            case R.id.btn_ulsan: //울산광역시
                indexLengthCall = apiService.getUlsanIndexLength();
                break;
            case R.id.btn_gyeonggi: //경기도
                indexLengthCall = apiService.getGyeonggiIndexLength();
                break;
            case R.id.btn_gyeongsang: //경상도
                indexLengthCall = apiService.getGyeongsangIndexLength();
                break;
            case R.id.btn_jeonlla: //전라도
                indexLengthCall = apiService.getJeonllaIndexLength();
                break;
            case R.id.btn_chungcheong: //충청도
                indexLengthCall = apiService.getChungcheongIndexLength();
                break;
            case R.id.btn_gangwon: //강원도
                indexLengthCall = apiService.getGangwonIndexLength();
                break;
            case R.id.btn_sejong: //세종특별자치시
                indexLengthCall = apiService.getSejongIndexLength();
                break;
            case R.id.btn_jeju: //제주특별자치도
                indexLengthCall = apiService.getJejuIndexLength();
                break;
            // 메인 카테고리별 버튼들
            case R.id.btn_trip: //여행관련
                indexLengthCall = apiService.getTripIndexLength();
                break;
            case R.id.btn_food: //음식관련
                indexLengthCall = apiService.getFoodIndexLength();
                break;
            case R.id.btn_cult: //문화관련
                indexLengthCall = apiService.getCultIndexLength();
                break;
            case R.id.btn_buty: //미용관련
                indexLengthCall = apiService.getButyIndexLength();
                break;
            case R.id.btn_medi: //의료관련
                indexLengthCall = apiService.getMediIndexLength();
                break;
            //지역별꺼
//            case R.id.btn_medi:
//                indexLengthCall = apiService.getMediIndexLength();
//                break;
            case R.id.btn_camp: //숙소관련
            default:
                indexLengthCall = apiService.getCampIndexLength();
                break;
        }

        indexLengthCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (isRemoving()) {
                    return; // 프래그먼트가 종료되었으면 중지
                }

//                if (isRequestCompleted) {
//                    // 이미 요청이 완료된 경우, 처리를 중단
//                    return;
//                }

                if (!response.isSuccessful()) {
                    // indexLength 를 가져오는 요청이 실패한 경우 처리
                    return;
                }

                apiLength = response.body();

                Log.e("INDEX LENGTH", String.valueOf(apiLength));

                recyclerView = categoryView.findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                customAdapter = new CustomAdapter();
                recyclerView.setAdapter(customAdapter); // 어탭터 설정

                //----------------------------------------------------
                recyclerView.addOnScrollListener(scrollListener = new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                    }

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);

                        loadData();
                    }
                });

                loadData();
//                isRequestCompleted = true;
            }


            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                // indexLength 를 가져오는 요청이 실패한 경우 처리
            }
        });

        return categoryView;
    }

    private void loadData() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (loadedApiLength >= apiLength) {
            //모두 로드 되었음
            return;
        }

        if (layoutManager == null) {
            return;
        }

        if (layoutManager.findLastCompletelyVisibleItemPosition() < customAdapter.getItemCount() - 1) {
            return;
        }

        for (int i = 0; i < apiLength; i++) {
            // 데이터 넣기
            switch (mCategory) {
                // 지역버튼들
                case R.id.btn_seoul:
                    callApiFacility = apiService.getSeoulFacility(i);
                    break;
                case R.id.btn_busan:
                    callApiFacility = apiService.getBusanFacility(i);
                    break;
                case R.id.btn_incheon:
                    callApiFacility = apiService.getIncheonFacility(i);
                    break;
                case R.id.btn_daegu:
                    callApiFacility = apiService.getDaeguFacility(i);
                    break;
                case R.id.btn_daejeon:
                    callApiFacility = apiService.getDaejeonFacility(i);
                    break;
                case R.id.btn_gwangju:
                    callApiFacility = apiService.getGwangjuFacility(i);
                    break;
                case R.id.btn_ulsan:
                    callApiFacility = apiService.getUlsanFacility(i);
                    break;
                case R.id.btn_gyeonggi:
                    callApiFacility = apiService.getGyeonggiFacility(i);
                    break;
                case R.id.btn_gyeongsang:
                    callApiFacility = apiService.getGyeongsangFacility(i);
                    break;
                case R.id.btn_jeonlla:
                    callApiFacility = apiService.getJeonllaFacility(i);
                    break;
                case R.id.btn_chungcheong:
                    callApiFacility = apiService.getChungcheongFacility(i);
                    break;
                case R.id.btn_gangwon:
                    callApiFacility = apiService.getGangwonFacility(i);
                    break;
                case R.id.btn_sejong:
                    callApiFacility = apiService.getSejongFacility(i);
                    break;
                case R.id.btn_jeju:
                    callApiFacility = apiService.getJejuFacility(i);
                    break;
                // 메인 카테고리별 버튼들
                case R.id.btn_trip:
                    callApiFacility = apiService.getTripFacility(i);
                    break;
                case R.id.btn_food:
                    callApiFacility = apiService.getFoodFacility(i);
                    break;
                case R.id.btn_cult:
                    callApiFacility = apiService.getCultFacility(i);
                    break;
                case R.id.btn_buty:
                    callApiFacility = apiService.getButyFacility(i);
                    break;
                case R.id.btn_medi:
                    callApiFacility = apiService.getMediFacility(i);
                    break;
                //지역별꺼
//                case R.id.btn_medi:
//                    callApiFacility = apiService.getMediFacility(i);
//                    break;
                case R.id.btn_camp:
                default:
                    callApiFacility = apiService.getCampFacility(i);
                    break;
            }
            //
            callApiFacility.enqueue(new Callback<ApiFacility>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<ApiFacility> call, Response<ApiFacility> response) {
                    loadedApiLength++;

                    if (isRemoving()) {
                        return; //프래그먼트가 종료되었으면 중지
                    }
//                                Log.e("dzdzdzdzzddz","dwdwwddwwddwwd");
                    if (!response.isSuccessful()) {
                        Log.e("server code", String.valueOf(response.code()));
                        Log.e("response", "fail");
                        return;
                    }

                    ApiFacility apiInfo = response.body();

                    // 리사작업 ///////////////////////////////////////////
                    String placeName = apiInfo.getName(); //상호명
                    String placeAddr1 = apiInfo.getCity(); //도시명
                    String placeAddr2 = apiInfo.getDistrict(); //도로명 주소
                    String placeInfo = apiInfo.getCategory3(); // 업종명
                    String placeOtherInfo = apiInfo.getParkingAvailable(); //주차가능
                    ViewItemData viewItemData = new ViewItemData(placeName, placeAddr1, placeAddr2, placeOtherInfo, placeInfo);
                    customAdapter.add(viewItemData);
                    progressBar.setVisibility(View.GONE);


                    /////////////////////////////////////////////////////////////////////////////////////////////

                }

                @Override
                public void onFailure(Call<ApiFacility> call, Throwable t) {
                    loadedApiLength++;
                }
            });
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onDestroy() {
        super.onDestroy();

//        isRequestCompleted = false;

        if (customAdapter != null) {
            customAdapter.clear();
        }

        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(scrollListener);
        }
        if (callApiFacility != null) {
            callApiFacility.cancel();
        }

    }

}
