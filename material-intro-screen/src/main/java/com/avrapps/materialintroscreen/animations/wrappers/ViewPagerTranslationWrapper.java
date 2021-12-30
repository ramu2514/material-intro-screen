package com.avrapps.materialintroscreen.animations.wrappers;

import android.view.View;

import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;
import com.avrapps.materialintroscreen.animations.translations.AlphaTranslation;
import com.avrapps.materialintroscreen.animations.translations.DefaultAlphaTranslation;

public class ViewPagerTranslationWrapper extends ViewTranslationWrapper {
    public ViewPagerTranslationWrapper(View view) {
        super(view);

        setDefaultTranslation(new DefaultAlphaTranslation())
                .setExitTranslation(new AlphaTranslation());
    }
}