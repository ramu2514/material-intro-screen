package com.avrapps.materialintroscreen.animations.wrappers;

import android.view.View;

import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;
import com.avrapps.materialintroscreen.animations.translations.DefaultPositionTranslation;
import com.avrapps.materialintroscreen.animations.translations.ExitDefaultTranslation;

public class PageIndicatorTranslationWrapper extends ViewTranslationWrapper {
    public PageIndicatorTranslationWrapper(View view) {
        super(view);

        setDefaultTranslation(new DefaultPositionTranslation())
                .setExitTranslation(new ExitDefaultTranslation());
    }
}