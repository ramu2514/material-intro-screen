package com.avrapps.materialintroscreen.listeners;

import com.avrapps.materialintroscreen.widgets.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import com.avrapps.materialintroscreen.adapter.SlidesAdapter;
import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;

public class ViewBehavioursOnPageChangeListener implements CustomViewPager.OnPageChangeListener {
    private final SlidesAdapter adapter;

    private List<IPageSelectedListener> listeners = new ArrayList<>();
    private List<ViewTranslationWrapper> wrappers = new ArrayList<>();
    private List<IPageScrolledListener> pageScrolledListeners = new ArrayList<>();

    public ViewBehavioursOnPageChangeListener(SlidesAdapter adapter) {
        this.adapter = adapter;
    }

    public ViewBehavioursOnPageChangeListener registerPageSelectedListener(IPageSelectedListener pageSelectedListener) {
        listeners.add(pageSelectedListener);
        return this;
    }

    public ViewBehavioursOnPageChangeListener registerViewTranslationWrapper(ViewTranslationWrapper wrapper) {
        wrappers.add(wrapper);
        return this;
    }

    public ViewBehavioursOnPageChangeListener registerOnPageScrolled(IPageScrolledListener pageScrolledListener) {
        pageScrolledListeners.add(pageScrolledListener);
        return this;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (isFirstSlide(position)) {
            for (ViewTranslationWrapper wrapper : wrappers) {
                wrapper.enterTranslate(positionOffset);
            }
        } else if (adapter.isLastSlide(position)) {
            for (ViewTranslationWrapper wrapper : wrappers) {
                wrapper.exitTranslate(positionOffset);
            }
        } else {
            for (ViewTranslationWrapper wrapper : wrappers) {
                wrapper.defaultTranslate(positionOffset);
            }
        }

        for (IPageScrolledListener pageScrolledListener : pageScrolledListeners) {
            pageScrolledListener.pageScrolled(position, positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {
        for (IPageSelectedListener pageSelectedListener : listeners) {
            pageSelectedListener.pageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private boolean isFirstSlide(int position) {
        return position == 0;
    }
}