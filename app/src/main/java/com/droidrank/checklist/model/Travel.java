package com.droidrank.checklist.model;

/**
 * Created by josue on 11/6/18.
 */

public class Travel {
    private String name;
    private boolean checkItem;

    public Travel(String name) {
        setName(name);
        setCheckItem(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckItem() {
        return checkItem;
    }

    public void setCheckItem(boolean checkItem) {
        this.checkItem = checkItem;
    }
}
