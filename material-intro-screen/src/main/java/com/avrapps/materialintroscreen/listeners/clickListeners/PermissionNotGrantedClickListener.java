package com.avrapps.materialintroscreen.listeners.clickListeners;

import android.view.View;

import com.avrapps.materialintroscreen.MaterialIntroActivity;
import com.avrapps.materialintroscreen.animations.ViewTranslationWrapper;

public class PermissionNotGrantedClickListener implements View.OnClickListener {
    private final MaterialIntroActivity activity;
    private final ViewTranslationWrapper translationWrapper;

    public PermissionNotGrantedClickListener(MaterialIntroActivity activity, ViewTranslationWrapper translationWrapper) {
        this.activity = activity;
        this.translationWrapper = translationWrapper;
    }

    @Override
    public void onClick(View v) {
        translationWrapper.error();
        activity.showPermissionsNotGrantedError();
    }
}