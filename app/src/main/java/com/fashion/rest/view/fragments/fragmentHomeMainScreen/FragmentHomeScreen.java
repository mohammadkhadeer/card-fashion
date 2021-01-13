package com.fashion.rest.view.fragments.fragmentHomeMainScreen;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.fashion.rest.R;
import com.fashion.rest.model.Deal;
import com.fashion.rest.model.Offer;
import com.fashion.rest.view.fragments.HomeScreenFragment.FragmentCategory;
import com.fashion.rest.view.fragments.HomeScreenFragment.FragmentOffers;
import com.fashion.rest.view.fragments.HomeScreenFragment.FragmentTest;
import java.util.ArrayList;
import java.util.List;

public class FragmentHomeScreen extends Fragment{

    View view;
    List<Offer> mList = new ArrayList<>();
    public ArrayList<Deal> dealsArrayList = new ArrayList<>();

    FragmentOffers fragmentOffers = new FragmentOffers();
    FragmentTest fragmentTest = new FragmentTest();
    FragmentCategory fragmentCategory = new FragmentCategory();
    NestedScrollView nestedScrollView;


    public FragmentHomeScreen(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        inti();
        //handelTestFragment();
        handelOffersFragment();
        handelCategoryFragment();
        actionListenerToNestedScroll();

        return view;
    }

    private void actionListenerToNestedScroll() {
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new
                                                                                  ViewTreeObserver.OnScrollChangedListener() {
                                                                                      @Override
                                                                                      public void onScrollChanged() {
                                                                                          View view = (View) nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                                                                                          int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()));
                                                                                          if (diff == 0) {
                                                                                              fragmentCategory.loadMore();
                                                                                              //code to fetch more data for endless scrolling

                                                                                          }
                                                                                      }
                                                                                  });
    }

    private void inti() {
        nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested);
    }

    private void handelCategoryFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_category, fragmentCategory)
                .commit();
    }

    private void handelOffersFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_offers, fragmentOffers)
                .commit();
    }

}
