package com.jgy.animal.slideviewpagers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

// 베너 이미지 자동 스크롤을 위한 코드
public class ViewPagerCustomDuration extends ViewPager {

    public ViewPagerCustomDuration(@NonNull Context context) {
        super(context);
        postInitViewPager();
    }

    public ViewPagerCustomDuration(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        postInitViewPager();
    }

    // 스크롤 애니메이션의 지속 시간을 조절하는데 사용
    private ScrollerCustomDuration mScroller = null;

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     */

    private void postInitViewPager() {
        try {

            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);

            if (mScroller == null) {
                mScroller = new ScrollerCustomDuration(getContext(), (Interpolator) interpolator.get(null));
            }
            scroller.set(this, mScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Set the factor by which the duration will change
     */

    public void setScrollDurationFactor(double scrollFactor) {
        mScroller.setScrollDurationFactor(scrollFactor);
    }

}
