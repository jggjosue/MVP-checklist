package com.droidrank.checklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.droidrank.checklist.view.adapter.ItemAdapterView;
import com.droidrank.checklist.view.main.MainActivityContract;
import com.droidrank.checklist.view.main.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityContract.Presenter presenter;

    // To display the items in the list
    private RecyclerView listView;
    // To add a new item
    private Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        linkUI();
        setListener();
    }

    private void linkUI() {
        listView = (RecyclerView) findViewById(R.id.list_view);
        addNew = (Button) findViewById(R.id.bt_add_new_item);
    }

    private void setListener() {
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Add a new item to the checklist
                 */
                presenter.clickAddNew();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Refresh the checklist
        presenter.refreshList();
    }


    @Override
    public void showTravels(ItemAdapterView adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(llm);
        listView.setAdapter(adapter);
    }
}
