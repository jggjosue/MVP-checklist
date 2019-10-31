package com.droidrank.checklist.session;

import android.content.Context;

import java.util.ArrayList;

import com.droidrank.checklist.R;
import com.droidrank.checklist.model.Travel;

/**
 * Created by josue on 11/6/18.
 */

public class Session {
    private static Session theInstance = null;

    public static Session getInstance(Context context) {
        if (theInstance == null)
            theInstance = new Session(context);

        return theInstance;
    }

    private Session(Context context) {
        this.context = context;
        initTravels();
    }

    private Context context;
    private ArrayList<Travel> travels = new ArrayList<>();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Travel> getTravels() {
        return travels;
    }

    public void setTravels(ArrayList<Travel> travels) {
        this.travels = travels;
    }

    private void initTravels() {
        String[] travelsInit = context.getResources().getStringArray(R.array.default_items);
        for (String travel : travelsInit) {
            travels.add(new Travel(travel));
        }
    }
}
