package com.avrapps.materialintroscreen.animations.translations;

import androidx.annotation.FloatRange;
import android.view.View;

import com.avrapps.materialintroscreen.animations.IViewTranslation;

public class DefaultAlphaTranslation implements IViewTranslation {
    @Override
    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
        view.setAlpha(1f);
    }
}
