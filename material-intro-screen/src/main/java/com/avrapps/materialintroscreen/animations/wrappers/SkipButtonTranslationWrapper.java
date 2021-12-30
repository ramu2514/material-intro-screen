package com.avrapps.materialintroscreen.animations.wrappers;

import android.view.View;

import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;
import com.avrapps.materialintroscreen.animations.translations.DefaultPositionTranslation;
import com.avrapps.materialintroscreen.animations.translations.EnterDefaultTranslation;
import com.avrapps.materialintroscreen.animations.translations.ExitDefaultTranslation;

public class SkipButtonTranslationWrapper extends ViewTranslationWrapper {
    public SkipButtonTranslationWrapper(View view) {
        super(view);

        setEnterTranslation(new EnterDefaultTranslation())
                .setDefaultTranslation(new DefaultPositionTranslation())
                .setExitTranslation(new ExitDefaultTranslation());
    }
}