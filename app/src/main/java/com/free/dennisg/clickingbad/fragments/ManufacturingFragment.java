package com.free.dennisg.clickingbad.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.free.dennisg.clickingbad.R;
import com.free.dennisg.clickingbad.activities.MainActivity;
import com.free.dennisg.clickingbad.adapters.ManufacturingAdapter;
import com.free.dennisg.clickingbad.model.Manufacturing;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dennis Gimbergsson on 2017-09-24.
 **/

public class ManufacturingFragment extends Fragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Manufacturing> manufacturingList;
    private MainActivity mainActivity = new MainActivity();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manufacturing, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        manufacturingList = new ArrayList<>();
        manufacturingList.add(
                new Manufacturing(
                        1337, "1", "2", 3,4, 5, 6, 7)
        );
        manufacturingList.add(
                new Manufacturing(
                        1338, "1","2",3,4,5,6, 7));

        adapter = new ManufacturingAdapter(getContext(), manufacturingList);
        recyclerView.setAdapter(adapter);

        mainActivity.getMainTicker();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public int getMainTicket(){
        return mainActivity.getMainTicker();
    }
}
