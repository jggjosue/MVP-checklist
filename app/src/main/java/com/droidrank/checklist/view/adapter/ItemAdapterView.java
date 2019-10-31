package com.droidrank.checklist.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.droidrank.checklist.R;
import com.droidrank.checklist.model.Travel;

import java.util.ArrayList;

/**
 * Created by josue on 11/6/18.
 */

public class ItemAdapterView extends RecyclerView.Adapter<ItemAdapterView.ItemViewHolder> implements ItemAdapterContract.View {
    private ItemAdapterContract.Presenter presenter = new ItemAdapterPresenter(this);
    private ArrayList<Travel> travels;
    private boolean onBinding;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.check_list_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.position = position;
        holder.txtItem.setText(travels.get(position).getName());
        onBinding = true;
        holder.checkItem.setChecked(travels.get(position).isCheckItem());
        onBinding = false;
    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        private CheckBox checkItem;
        private TextView txtItem;
        private Button btnItem;
        private int position;

        ItemViewHolder(android.view.View itemView) {
            super(itemView);
            checkItem = (CheckBox) itemView.findViewById(R.id.cb_item_status);
            checkItem.setOnCheckedChangeListener(this);
            txtItem = (TextView) itemView.findViewById(R.id.cb_item_status);
            btnItem = (Button) itemView.findViewById(R.id.bt_item_delete);
            btnItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            travels.remove(position);
            notifyDataSetChanged();
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!onBinding) {
                travels.get(position).setCheckItem(isChecked);
                travels = presenter.reoderList(travels);
                notifyDataSetChanged();
            }
        }
    }

    public ItemAdapterView(ArrayList<Travel> travels) {
        this.travels = presenter.reoderList(travels);
    }
}
