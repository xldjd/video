package com.example.instantmusicvideotest.untis;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // 最重要的设置，将viewpager翻转
        setPageTransformer(true, new VerticalPageTransformer());
        // 设置去掉滑到最左或最右时的滑动效果
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements PageTransformer {



        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position < -1) { // [-Infinity,-1)
                // 当前页的上一页
                page.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                page.setAlpha(1);

                // 抵消默认幻灯片过渡
                page.setTranslationX(page.getWidth() * -position);

                //设置从上滑动到Y位置
                float yPosition = position * page.getHeight();
                page.setTranslationY(yPosition);

            } else { // (1,+Infinity]
                // 当前页的下一页
                page.setAlpha(0);
            }
        }
        }


    /**
     * 交换触摸事件的X和Y坐标
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted; //为所有子视图返回触摸的原始坐标
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
}
