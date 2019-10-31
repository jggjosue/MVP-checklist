package com.droidrank.checklist.view.adapter;

import com.droidrank.checklist.model.Travel;

import java.util.ArrayList;

/**
 * Created by josue on 11/6/18.
 */

public interface ItemAdapterContract {
    interface View {

    }

    interface Presenter {
        ArrayList<Travel> reoderList(ArrayList<Travel> travels);
    }
}
