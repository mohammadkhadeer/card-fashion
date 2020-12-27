package com.fashion.rest.view.activity;

import android.graphics.Paint;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fashion.rest.R;
import com.fashion.rest.functions.Functions;
import com.fashion.rest.view.fragments.FragmentAddToCart;
import com.fashion.rest.view.fragments.FragmentImageSlider;
import com.fashion.rest.view.fragments.FragmentItemDetails;

public class ItemDetails extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appbar;
    TextView itemPriceTV,oldPriceTV,itemNewPriceTV,title;
    LinearLayout show_item_details_header;
    FragmentImageSlider fragmentImageSlider = new FragmentImageSlider();
    FragmentItemDetails fragmentItemDetails = new FragmentItemDetails();
    FragmentAddToCart fragmentAddToCart = new FragmentAddToCart();

    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        getInfoFromCat();
        inti();
        titleActionBar();
        intiImageSlider();
        SuggestedFragment();
        AddToCartFragment();
    }

    private void AddToCartFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_add_to_cart, fragmentAddToCart)
                .commit();
    }

    private void getInfoFromCat() {
        Bundle bundle = getIntent().getExtras();
        cat =bundle.getString("cat");
    }

    private void SuggestedFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("cat", cat);

        fragmentItemDetails.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_item_details, fragmentItemDetails)
                .commit();
    }

    private void intiImageSlider() {
        Bundle bundle = new Bundle();
        bundle.putString("itemName", "Bracelets name");
        bundle.putString("cat", "Bracelets");

        fragmentImageSlider.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_image_slider_container, fragmentImageSlider);
        transaction.commit();
    }

    private void inti() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.show_item_details_toolbar);
        appbar = (AppBarLayout)findViewById(R.id.show_item_details_app_bar);

        itemPriceTV = (TextView) findViewById(R.id.show_item_details_car_price);
        oldPriceTV = (TextView) findViewById(R.id.show_item_details_car_old_price);
        itemNewPriceTV = (TextView) findViewById(R.id.show_item_details_new_price);
        show_item_details_header = (LinearLayout) findViewById(R.id.show_item_details_header);
        title = (TextView) findViewById(R.id.show_item_details_title);
    }

    private void titleActionBar() {
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        fillPrice();
        title.setText(getResources().getString(R.string.item_name));
        title.setTypeface(Functions.changeFontGeneral(getApplicationContext()));

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    show_item_details_header.setVisibility(View.VISIBLE);
                    collapsingToolbarLayout.setTitle(getResources().getString(R.string.item_name));

                    statusBarColor();
                    isVisible = true;
                } else if (isVisible) {
                    collapsingToolbarLayout.setTitle(" ");
                    show_item_details_header.setVisibility(View.GONE);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    isVisible = false;
                }
            }
        });
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    private void fillPrice() {
        String priceEdit="1";
        if (priceEdit.equals("0"))
        {
            itemPriceTV.setVisibility(View.VISIBLE);
            oldPriceTV.setVisibility(View.GONE);
            itemNewPriceTV.setText("123"
                    +" "+getResources().getString(R.string.jod));
            //itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            //set new price empty to stay design
            itemPriceTV.setText("");
            //itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            itemPriceTV.setVisibility(View.GONE);
            oldPriceTV.setVisibility(View.VISIBLE);

            oldPriceTV.setText("123");
            //change text color
            oldPriceTV.setTextColor(getResources().getColor(R.color.colorWhite));
            //set line above old price
            oldPriceTV.setPaintFlags(itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            //change size new price
            //itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);

            itemNewPriceTV.setText("199"
                    +" "+getResources().getString(R.string.jod));
            //fill old price
            itemPriceTV.setText("250"
                    +" "+getResources().getString(R.string.jod));

        }
    }
}