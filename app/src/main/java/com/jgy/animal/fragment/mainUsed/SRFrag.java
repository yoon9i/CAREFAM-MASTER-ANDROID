package com.jgy.animal.fragment.mainUsed;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
import com.jgy.animal.interfaces.CallApi;
import com.jgy.animal.repository.ApiFacility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SRFrag extends Fragment {

    public final static String KEY_INPUT_QUERY = "INPUT_QUERY";

    RecyclerView recyclerView = null;
    CustomAdapter customAdapter = null;

    int apiLength;
    int loadedApiLength;
    String query;

    private ProgressBar progressBar;
    Call<Integer> indexLengthCall;
    Call<ApiFacility> callApiFacility;
    RecyclerView.OnScrollListener scrollListener;

    private CallApi apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        query = bundle.getString(KEY_INPUT_QUERY, "");

        View srView = inflater.inflate(R.layout.recycler_view, container, false);

        progressBar = srView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.15:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(CallApi.class);

        indexLengthCall = apiService.getSearchIndexLength(query);

        indexLengthCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (isRemoving()) {
                    return;
                }
                if (!response.isSuccessful()) {
                    return;
                }

                apiLength = response.body();

                recyclerView = srView.findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                customAdapter = new CustomAdapter();
                recyclerView.setAdapter(customAdapter);

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
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        return srView;
    }

    private void loadData() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (loadedApiLength >= apiLength) {
            return;
        }
        if (layoutManager == null) {
            return;
        }
        if (layoutManager.findLastCompletelyVisibleItemPosition() < customAdapter.getItemCount() -1 ) {
            return;
        }

        for (int i = 0; i < apiLength; i++) {
            callApiFacility = apiService.getSearchFacility(i, query);
            callApiFacility.enqueue(new Callback<ApiFacility>() {
                @Override
                public void onResponse(Call<ApiFacility> call, Response<ApiFacility> response) {
                    loadedApiLength++;

                    if (isRemoving()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        return;
                    }

                    ApiFacility apiInfo = response.body();

                    String placeName = apiInfo.getName(); //상호명
                    String placeAddr1 = apiInfo.getCity(); //도시명
                    String placeAddr2 = apiInfo.getDistrict(); //도로명 주소
                    String placeOtherInfo = apiInfo.getParkingAvailable(); //주차가능
                    ViewItemData viewItemData = new ViewItemData(placeName, placeAddr1, placeAddr2, placeOtherInfo);
                    customAdapter.add(viewItemData);
                    progressBar.setVisibility(View.GONE);
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
