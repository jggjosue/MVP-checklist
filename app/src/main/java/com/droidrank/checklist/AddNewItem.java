package com.droidrank.checklist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.droidrank.checklist.view.add_item.AddNewItemContract;
import com.droidrank.checklist.view.add_item.AddNewItemPresenter;

public class AddNewItem extends AppCompatActivity implements AddNewItemContract.View {
    private AddNewItemContract.Presenter presenter = new AddNewItemPresenter(this);

    // To take the user input for the new item
    private EditText itemName;
    // To add the new item to the list
    private Button addItem;
    // To cancel this task
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        linkUI();
        setListener();
    }

    private void linkUI() {
        itemName = (EditText) findViewById(R.id.et_item_name);
        cancel = (Button) findViewById(R.id.bt_cancel);
        addItem = (Button) findViewById(R.id.bt_ok);
    }

    private void setListener() {
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *Save the new item, if it does not exist in the list
                 *else display appropriate error message
                 */
                // finish the current activity
                presenter.addNewItem(itemName.getText().toString());
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Do nothing and close this activity
                 */
                finish();
            }
        });
    }

    @Override
    public void showItemExits() {
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage(getResources().getString(R.string.item_already_exists_message))
                .setPositiveButton(getResources().getString(R.string.ok_text), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        itemName.setText("");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .show();
    }
}
