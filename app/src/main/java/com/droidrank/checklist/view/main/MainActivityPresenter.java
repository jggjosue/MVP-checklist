package com.droidrank.checklist.view.main;

import android.content.Context;
import android.content.Intent;

import com.droidrank.checklist.AddNewItem;
import com.droidrank.checklist.MainActivity;
import com.droidrank.checklist.session.Session;
import com.droidrank.checklist.view.adapter.ItemAdapterView;

/**
 * Created by josue on 11/6/18.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;
    private Session session;
    private Context context;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        context = (MainActivity) view;
        session = Session.getInstance(context);
    }

    @Override
    public void refreshList() {
        ItemAdapterView adapter = new ItemAdapterView(session.getTravels());
        view.showTravels(adapter);
    }

    @Override
    public void clickAddNew() {
        Intent intent = new Intent(context, AddNewItem.class);
        context.startActivity(intent);
    }
}
