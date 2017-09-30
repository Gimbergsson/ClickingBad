package com.free.dennisg.clickingbad.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.free.dennisg.clickingbad.R;
import com.free.dennisg.clickingbad.fragments.ManufacturingFragment;
import com.free.dennisg.clickingbad.model.Manufacturing;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dennis Gimbergsson on 2017-09-24.
 **/

public class DistributionAdapter extends RecyclerView.Adapter<DistributionAdapter.ViewHolder> {

    private List<Manufacturing> manufacturingList;
    private Context context;
    private ManufacturingFragment manufacturingFragment = new ManufacturingFragment();

    public DistributionAdapter(Context context, List<Manufacturing> manufacturingList) {
        this.manufacturingList = manufacturingList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_id) TextView itemId;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public DistributionAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.manufacturing_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DistributionAdapter.ViewHolder viewHolder, int position) {
        Manufacturing manufacturing = manufacturingList.get(position);
        viewHolder.itemId.setText(String.valueOf(manufacturing.getItemId()) + " " + manufacturing.getName());
    }

    @Override
    public int getItemCount() {
        return manufacturingList.size();
    }
}
