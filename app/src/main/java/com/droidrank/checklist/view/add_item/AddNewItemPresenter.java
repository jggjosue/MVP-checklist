package com.droidrank.checklist.view.add_item;

import android.text.TextUtils;

import com.droidrank.checklist.AddNewItem;
import com.droidrank.checklist.model.Travel;
import com.droidrank.checklist.session.Session;

/**
 * Created by josue on 11/6/18.
 */

public class AddNewItemPresenter implements AddNewItemContract.Presenter {
    private AddNewItemContract.View view;
    private Session session = Session.getInstance(null);

    public AddNewItemPresenter(AddNewItemContract.View view) {
        this.view = view;
    }

    @Override
    public void addNewItem(String name) {
        if (!TextUtils.isEmpty(name)) {
            if (isExist(name))
                view.showItemExits();
            else {
                session.getTravels().add(new Travel(name));
                ((AddNewItem) view).finish();
            }
        }
    }

    private boolean isExist(String name) {
        for (Travel travel : session.getTravels()) {
            if (travel.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }
}
