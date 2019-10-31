package com.droidrank.checklist.view.add_item;

/**
 * Created by josue on 11/6/18.
 */

public interface AddNewItemContract {
    interface View {
        void showItemExits();
    }

    interface Presenter {
        void addNewItem(String name);
    }
}
