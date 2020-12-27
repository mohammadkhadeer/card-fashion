package com.fashion.rest.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fashion.rest.R;
import com.fashion.rest.functions.Functions;
import com.fashion.rest.model.Deal;
import com.fashion.rest.view.Adapters.AdapterSet;
import com.fashion.rest.view.activity.CategoryItem;

import java.util.ArrayList;

import static com.fashion.rest.functions.FillItem.fillAllItemDepCatArrayL;


public class FragmentSuggested extends Fragment implements AdapterSet.PassItem{
    View view;
    RecyclerView recyclerView;
    AdapterSet adapterSet;
    RecyclerView.LayoutManager layoutManager;
    public ArrayList<Deal> dealsArrayList = new ArrayList<>();
    TextView headerTV;
    RelativeLayout relativeLayout;
    String cat;
    public FragmentSuggested(){}

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            cat = getArguments().getString("cat");
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_suggested, container, false);
        inti();
        createRVSuggested();
        changeFont();
        actionListenerToSeeAll();
        return view;
    }

    private void actionListenerToSeeAll() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category",getActivity().getResources().getString(R.string.set));
                bundle.putString("from","see_all");

                Intent intent = new Intent(getActivity(), CategoryItem.class);
                intent.putExtras(bundle);
                ((Activity)getActivity()).startActivity(intent);
                ((Activity)getActivity()).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void changeFont() {
        headerTV.setTypeface(Functions.changeFontCategory(getActivity()));
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.suggested_RV);
        headerTV = (TextView) view.findViewById(R.id.suggested_TV);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.see_all_suggested_rl);
    }

    private void createRVSuggested() {
        dealsArrayList = fillAllItemDepCatArrayL(cat,getActivity());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapterSet =new AdapterSet(getActivity()
                ,dealsArrayList,cat,this);
        recyclerView.setAdapter(adapterSet);
    }

    @Override
    public void onClicked(Deal deal) {

    }
}
