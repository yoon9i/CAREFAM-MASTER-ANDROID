package com.jgy.animal.fragment.btnUsed.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;

import com.jgy.animal.R;

public class CampAddrDialog extends AppCompatDialog implements View.OnClickListener {
    @LayoutRes private int mLayoutRes;

    public CampAddrDialog(@NonNull Context context) {
        super(context);
    }

    public CampAddrDialog(@NonNull Context context, @StyleableRes int theme) {
        super(context, theme);
    }

    public CampAddrDialog(@NonNull Context context, @LayoutRes int layoutRes, @StyleableRes int theme) {
        super(context, theme);
        mLayoutRes = layoutRes;
    }

    protected CampAddrDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        android.app.ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null) {
            supportActionBar.hide();
        }

        View view = LayoutInflater.from(this.getContext()).inflate(mLayoutRes, null, false);

//        setContentView(view);
//        setContentView(view, new ViewGroup.LayoutParams((int)(1280 * 0.7), 300));
//        setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(view, new ViewGroup.LayoutParams(700, 900));

        RadioButton 강원 = view.findViewById(R.id.강원);
        RadioButton 경기 = view.findViewById(R.id.경기);
        RadioButton 경남 = view.findViewById(R.id.경남);
        RadioButton 경북 = view.findViewById(R.id.경북);
        RadioButton 광주 = view.findViewById(R.id.광주);

        RadioButton 대구 = view.findViewById(R.id.대구);
        RadioButton 대전 = view.findViewById(R.id.대전);
        RadioButton 부산 = view.findViewById(R.id.부산);
        RadioButton 서울 = view.findViewById(R.id.서울);
        RadioButton 세종 = view.findViewById(R.id.세종);

        RadioButton 울산 = view.findViewById(R.id.울산);
        RadioButton 인천 = view.findViewById(R.id.인천);
        RadioButton 전남 = view.findViewById(R.id.전남);
        RadioButton 전북 = view.findViewById(R.id.전북);
        RadioButton 제주 = view.findViewById(R.id.제주);

        RadioButton 충남 = view.findViewById(R.id.충남);
        RadioButton 충북 = view.findViewById(R.id.충북);

        강원.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Log.e("","ok");
    }
}
