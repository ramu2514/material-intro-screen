package com.avrapps.materialintroscreen.animations.wrappers;

import android.view.View;

import com.avrapps.materialintroscreen.R;
import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;
import com.avrapps.materialintroscreen.animations.translations.DefaultPositionTranslation;
import com.avrapps.materialintroscreen.animations.translations.ExitDefaultTranslation;

public class NextButtonTranslationWrapper extends ViewTranslationWrapper {
    public NextButtonTranslationWrapper(View view) {
        super(view);

        setExitTranslation(new ExitDefaultTranslation())
                .setDefaultTranslation(new DefaultPositionTranslation())
                .setErrorAnimation(R.anim.shake_it);
    }
}