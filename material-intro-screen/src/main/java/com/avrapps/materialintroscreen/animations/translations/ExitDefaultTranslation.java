package com.avrapps.materialintroscreen.animations.translations;

import android.view.View;

import androidx.annotation.FloatRange;
import com.avrapps.materialintroscreen.R;
import com.avrapps.materialintroscreen.animations.IViewTranslation;

public class ExitDefaultTranslation implements IViewTranslation {
    @Override
    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
        view.setTranslationY(percentage * view.getResources().getDimensionPixelOffset(R.dimen.y_offset));
    }
}
