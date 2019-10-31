package com.droidrank.checklist.view.adapter;

import android.content.Context;

import com.droidrank.checklist.model.Travel;
import com.droidrank.checklist.session.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by josue on 11/6/18.
 */

public class ItemAdapterPresenter implements ItemAdapterContract.Presenter {
    private ItemAdapterContract.View view;

    ItemAdapterPresenter(ItemAdapterContract.View view) {
        this.view = view;
    }

    @Override
    public ArrayList<Travel> reoderList(ArrayList<Travel> travels) {
        ArrayList<Travel> checkedItem = new ArrayList<>();
        ArrayList<Travel> uncheckedItem = new ArrayList<>();
        for (Travel travel : travels) {
            if (travel.isCheckItem())
                checkedItem.add(travel);
            else
                uncheckedItem.add(travel);
        }

        sortList(checkedItem);
        sortList(uncheckedItem);

        travels.clear();
        travels.addAll(uncheckedItem);
        travels.addAll(checkedItem);

        return travels;
    }

    private void sortList(ArrayList<Travel> travels){
        Collections.sort(travels, new Comparator<Travel>() {
            @Override
            public int compare(Travel t1, Travel t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        });
    }
}
