package com.fashion.rest.view.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fashion.rest.R;
import com.fashion.rest.model.Deal;
import com.fashion.rest.model.ListItem;
import com.fashion.rest.utils.BaseViewHolderUser;
import com.fashion.rest.view.activity.mainScreem.MainActivity;
import com.fashion.rest.view.fragments.HomeScreenFragment.FragmentTest;
import com.fashion.rest.view.fragments.inSaidCategoriesRV.MainFragment;

import java.util.List;

import butterknife.ButterKnife;

import static com.fashion.rest.view.categoriesComp.FillType1.fill;
import static com.fashion.rest.view.categoriesComp.FillType2.fillCaseItem;
import static com.fashion.rest.view.categoriesComp.FillType3.fillCase3Item;
import static com.fashion.rest.view.categoriesComp.FillType4.fillCase4Item;


public class AdapterEndlessCategory extends RecyclerView.Adapter<BaseViewHolderUser> {
  private static final int VIEW_TYPE_LOADING = 0;
  private static final int VIEW_TYPE_NORMAL = 1;
  private boolean isLoaderVisible = false;

  private List<ListItem> dealItemsList;
  Context context;
  String comeFrom;

  public AdapterEndlessCategory(List<ListItem> postItems, Context context, String comeFrom) {
    this.dealItemsList = postItems;
    this.context = context;
    this.comeFrom = comeFrom;
  }

  @NonNull
  @Override
  public BaseViewHolderUser onCreateViewHolder(ViewGroup parent, int viewType) {

    switch (viewType) {
      case VIEW_TYPE_NORMAL:
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_offers_category, parent, false));
      case VIEW_TYPE_LOADING:
        return new ProgressHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading_category, parent, false));
      default:
        return null;
    }
  }

  @Override
  public void onBindViewHolder(@NonNull BaseViewHolderUser holder, int position) {
    holder.onBind(position);
    switch (getItemViewType(position)) {
      case VIEW_TYPE_NORMAL:

      case VIEW_TYPE_LOADING:

      default:
        break;
    }
  }

  @Override
  public int getItemViewType(int position) {
    if (isLoaderVisible) {
      return position == dealItemsList.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
    } else {
      return VIEW_TYPE_NORMAL;
    }
  }

  @Override
  public int getItemCount() {
    return dealItemsList == null ? 0 : dealItemsList.size();
  }

  public void addItems(List<ListItem> postItems) {
    dealItemsList.addAll(postItems);
    notifyDataSetChanged();
  }

  public void addLoading() {
    isLoaderVisible = true;
    dealItemsList.add(new ListItem());
    notifyItemInserted(dealItemsList.size() - 1);
  }

  public void removeLoading() {
    isLoaderVisible = false;
    ////////////here
    int position = dealItemsList.size() - 1;
    ListItem item = getItem(position);
    if (item != null) {
      dealItemsList.remove(position);
      notifyItemRemoved(position);
    }

  }

  ListItem getItem(int position) {
    return dealItemsList.get(position);
  }

  public class ViewHolder extends BaseViewHolderUser {
    ImageView imageView;
    RelativeLayout coverRL,cont1,cont2,cont3,cont4;
    TextView nameTV,desTV,priceTV,oldPrice;
    RecyclerView recyclerViewT2,recyclerViewT3,recyclerViewT4;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);


      imageView = (ImageView) itemView.findViewById(R.id.type1_IV) ;
      nameTV = (TextView) itemView.findViewById(R.id.adapter_name_TV);
//      desTV = (TextView) itemView.findViewById(R.id.adapter_des_TV);
//      priceTV = (TextView) itemView.findViewById(R.id.adapter_price_TV);
//      oldPrice = (TextView) itemView.findViewById(R.id.adapter_old_price_TV);
      coverRL = (RelativeLayout) itemView.findViewById(R.id.cover_typ1);

      cont1 = (RelativeLayout) itemView.findViewById(R.id.container_type1_rl);
      cont2 = (RelativeLayout) itemView.findViewById(R.id.container_type2_rl);
      cont3 = (RelativeLayout) itemView.findViewById(R.id.container_type3_rl);
      cont4 = (RelativeLayout) itemView.findViewById(R.id.container_type4_rl);

      recyclerViewT2 = (RecyclerView) itemView.findViewById(R.id.type2_RV);
      recyclerViewT3 = (RecyclerView) itemView.findViewById(R.id.type3_RV);

      recyclerViewT4 = (RecyclerView) itemView.findViewById(R.id.type4_RV);
    }

    protected void clear() {

    }

    MainFragment mainFragment;

    public void onBind(int position) {
      super.onBind(position);


      if (getObject(position).getListType().equals("type1"))
      {
        Log.i("TAG",getObject(position).getListType());
            cont1.setVisibility(View.VISIBLE);
            cont2.setVisibility(View.GONE);
            cont3.setVisibility(View.GONE);
            cont4.setVisibility(View.GONE);
            fill(imageView,nameTV,coverRL,getObject(position),context);
      }
      if (getObject(position).getListType().equals("type2"))
      {
        Log.i("TAG",getObject(position).getListType());
        cont1.setVisibility(View.GONE);
            cont2.setVisibility(View.VISIBLE);
            cont3.setVisibility(View.GONE);
            cont4.setVisibility(View.GONE);
            fillCaseItem(recyclerViewT2,context);
      }
      if (getObject(position).getListType().equals("type3"))
      {
        Log.i("TAG",getObject(position).getListType());
        cont1.setVisibility(View.GONE);
            cont2.setVisibility(View.GONE);
            cont3.setVisibility(View.VISIBLE);
            cont4.setVisibility(View.GONE);
            fillCase3Item(recyclerViewT3,context);
      }
      if (getObject(position).getListType().equals("type4"))
      {
        Log.i("TAG",getObject(position).getListType());
        cont1.setVisibility(View.GONE);
            cont2.setVisibility(View.GONE);
            cont3.setVisibility(View.GONE);
            cont4.setVisibility(View.VISIBLE);
            fillCase4Item(recyclerViewT4,context);
      }


      //fillCaseItem(imageView,nameTV,coverRL,getObject(position),context);
    }

  }

  private void fillText(TextView nameTV, int position, Context context) {
    nameTV.setText(String.valueOf(getObject(position).getListType()));
//    nameTV.setText(String.valueOf(position));
  }

  private ListItem getObject(int position){
    ListItem item = dealItemsList.get(position);
    return item;
  }



  public class ProgressHolder extends BaseViewHolderUser {
    CardView cardView;
    ImageView shinImageView,imageView,shinImageView2,imageView2,shinImageView3,imageView3
            ,shinImageView4,imageView4;
    TextView textViewNoMoreMessage;
    RelativeLayout relativeLayout,relativeLayout2,relativeLayout3,relativeLayout4,relativeLayoutNoMoreItem;
    ProgressHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

      cardView = (CardView) itemView.findViewById(R.id.adapter_show_user_item_cv);
      relativeLayoutNoMoreItem = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_no_more_cv);
      textViewNoMoreMessage = (TextView) itemView.findViewById(R.id.adapter_show_user_no_more_tv);
      shinImageView = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin);
      imageView = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load);
      relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl);

      shinImageView2 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin2);
      imageView2 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load2);
      relativeLayout2 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl2);

      shinImageView3 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin3);
      imageView3 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load3);
      relativeLayout3 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl3);

      shinImageView4 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_shin4);
      imageView4 = (ImageView) itemView.findViewById(R.id.adapter_show_user_item_item_image_load4);
      relativeLayout4 = (RelativeLayout) itemView.findViewById(R.id.adapter_show_user_item_item_image_load_rl4);
    }

    @Override
    protected void clear() {

    }

    public void onBind(int position) {
      super.onBind(position);
      int a= dealItemsList.size()-1, x = 0,mod=0;
      if (4 == dealItemsList.size())
      {
        x= 0;
        mod = 0;
      }else{
        x= a/4;
        mod = a % 4;
      }
      if (dealItemsList.size() ==1)
      {
        cardView.setVisibility(View.GONE);
        relativeLayoutNoMoreItem.setVisibility(View.GONE);
      }else {
        if(mod>0)
        {
          cardView.setVisibility(View.GONE);
          relativeLayoutNoMoreItem.setVisibility(View.VISIBLE);
        }else {
          AddShineEffect(relativeLayout, shinImageView);
          AddShineEffect(relativeLayout2, shinImageView2);
          AddShineEffect(relativeLayout3, shinImageView3);
          AddShineEffect(relativeLayout4, shinImageView4);
        }
      }
    }
  }

  String loadedOrDownloading="downloading";

  private void AddShineEffect(final RelativeLayout father, final ImageView child) {
    new Handler().postDelayed(new Runnable() {

      @Override
      public void run() {
        animationEffect(father,child);
        if (loadedOrDownloading.equals("downloading"))
          AddShineEffect(father,child);
      }
    }, 400);
  }

  private void animationEffect(RelativeLayout father, ImageView child) {
    Animation animation = new TranslateAnimation(0,
            father.getWidth()+child.getWidth(),0, 0);
    animation.setDuration(550);
    animation.setFillAfter(false);
    animation.setInterpolator(new AccelerateDecelerateInterpolator());
    child.startAnimation(animation);
  }

}