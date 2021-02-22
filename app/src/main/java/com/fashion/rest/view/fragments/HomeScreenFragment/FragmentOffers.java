package com.fashion.rest.view.fragments.HomeScreenFragment;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fashion.rest.R;
import com.fashion.rest.functions.Functions;
import com.fashion.rest.model.Categories;
import com.fashion.rest.model.Deal;
import com.fashion.rest.presnter.JsonPlaceHolderApi;
import com.fashion.rest.presnter.PassObject;
import com.fashion.rest.utils.PaginationListener;
import com.fashion.rest.view.Adapters.AdapterEndlessOffers;
import com.fashion.rest.view.Adapters.AdapterOffers;
import com.fashion.rest.view.activity.AllCategory;
import com.fashion.rest.view.activity.SplashScreen;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.fashion.rest.functions.FillItem.fillEndlessItemDepCatArrayL;
import static com.fashion.rest.functions.RetrofitFunctions.getCategories;
import static com.fashion.rest.utils.PaginationListener.PAGE_START;
import static com.fashion.rest.view.categoriesComp.FillType3.fillCase3Item;


public class FragmentOffers extends Fragment{
    View view;
    RecyclerView recyclerView,recyclerViewCat;
    AdapterOffers adapterOffers;
    RecyclerView.LayoutManager layoutManager;
    public ArrayList<Deal> dealsArrayList = new ArrayList<>();
    public ArrayList<Deal> suggestedItemsArrayListTest;
    public ArrayList<Deal> suggestedItemsArrayListDO;

    PassObject passObject;

    public static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private boolean isLastPage = false;
    private int totalPage = 10;
    private boolean isLoading = false;

    LinearLayoutManager mLayoutManager;
    AdapterEndlessOffers adapterEndlessOffers ;

    RelativeLayout see_all_cat_rl;
    TextView see_all_cat_tv;

    int numberOfObjectNow = 0;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    Retrofit retrofit;
    public ArrayList<Categories> categoriesArrayList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        intiRet();
        getCategoriesList();
    }

    private void intiRet() {
        retrofit = getCategories();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    //fill categories
    private void getCategoriesList() {
        categoriesArrayList = new ArrayList<>();
        Call<List<Categories>> call = jsonPlaceHolderApi.getCategories();
        call.enqueue(new Callback<List<Categories>>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                if (!response.isSuccessful())
                { return; }
                List<Categories> countriesL = response.body();

                for (Categories categories:countriesL)
                {
                    categoriesArrayList.add(categories);
                }
                fillCase3Item(recyclerViewCat,getActivity(),categoriesArrayList);
            }
            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Log.i("TAG Error",t.getMessage());
            }
        });
    }

    public FragmentOffers(){}

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_offers, container, false);
        suggestedItemsArrayListDO = new ArrayList<>();
        suggestedItemsArrayListTest = new ArrayList<>();
        inti();
        createRV();
        changeFont();
        actionListenerToRV();
        actionListenerToSeeAllCat();

        //createRVSuggested();
        return view;
    }

    private void changeFont() {
        see_all_cat_tv.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void actionListenerToSeeAllCat() {
        see_all_cat_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAllCatActivity();
            }
        });
    }

    private void moveToAllCatActivity() {

        Intent intent = new Intent(getActivity(), AllCategory.class);
        intent.putExtra("categories", categoriesArrayList);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void actionListenerToRV() {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {

                    if (mLayoutManager != null && mLayoutManager.findLastCompletelyVisibleItemPosition() == suggestedItemsArrayListDO.size() - 1) {
                        //bottom of list!
                        Toast.makeText(getActivity(),"TAG !" +String.valueOf(currentPage)+ " Load more ...",Toast.LENGTH_SHORT).show();

                        new Handler().postDelayed(new Runnable() {

                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void run() {
                                Log.i("TAG BAG","currentPage: "+String.valueOf(currentPage));
                                doApiCall();

                            }
                        }, 2000);
                        currentPage ++;
                        isLoading = true;

                    }
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createRV() {
        adapterEndlessOffers = new AdapterEndlessOffers(new ArrayList<Deal>(),getActivity(),"call");
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterEndlessOffers);
        doApiCall();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void doApiCall() {
        suggestedItemsArrayListTest = new ArrayList<>();
        suggestedItemsArrayListTest = fillEndlessItemDepCatArrayL(suggestedItemsArrayListTest,getActivity());
        suggestedItemsArrayListDO = fillEndlessItemDepCatArrayL(suggestedItemsArrayListDO,getActivity());
//        suggestedItemsArrayListTest.addAll(suggestedItemsArrayListDO);

        //fill here
        if (currentPage != PAGE_START) adapterEndlessOffers.removeLoading();
        adapterEndlessOffers.addItems(suggestedItemsArrayListTest);
        if (currentPage < totalPage) {
            adapterEndlessOffers.addLoading();
            isLoading = false;
        } else {
            isLastPage = true;
        }
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.offer_RV);
        recyclerViewCat = (RecyclerView) view.findViewById(R.id.type3_RV);
        see_all_cat_rl = (RelativeLayout) view.findViewById(R.id.see_all_cat_rl);
        see_all_cat_tv = (TextView) view.findViewById(R.id.see_all_cat_tv);
    }

}
