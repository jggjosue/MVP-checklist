package com.droidrank.checklist.view.main;

import android.content.Context;

import com.droidrank.checklist.view.adapter.ItemAdapterView;

/**
 * Created by josue on 11/6/18.
 */

public interface MainActivityContract {
    interface View {
        void showTravels(ItemAdapterView adapter);
    }

    interface Presenter {
        void refreshList();
        void clickAddNew();
    }
}
