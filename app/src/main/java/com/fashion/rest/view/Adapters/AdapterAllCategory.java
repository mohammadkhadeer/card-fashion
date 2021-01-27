package com.fashion.rest.view.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fashion.rest.R;
import com.fashion.rest.functions.Functions;
import com.fashion.rest.model.Category;
import com.fashion.rest.model.CustomCategory;
import com.fashion.rest.model.Deal;
import com.fashion.rest.view.activity.ItemDetails;
import com.fashion.rest.view.activity.SubCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterAllCategory extends RecyclerView.Adapter<AdapterAllCategory.ViewHolder>{

    private final Context context;
//    List<Offer> mList = new ArrayList<>();
    ArrayList<CustomCategory> allCatArrayL = new ArrayList<>();
    public AdapterAllCategory
            (Context context,ArrayList<CustomCategory> allCatArrayL)
                {
                     this.context = context;
                    this.allCatArrayL = allCatArrayL;
                }

    public AdapterAllCategory.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_custom_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterAllCategory.ViewHolder holder, final int position) {

        fillImage(context,holder,position);
        changeFont(holder,context);
        fillText(holder,context,position);
        fillPorder(context,position,holder);
        actionListenerToCard(holder,context,position);
    }

    private void fillPorder(Context context, int position, ViewHolder holder) {
        if (allCatArrayL.get(position).getCustomCategory().size() != 0) {
            if (allCatArrayL.get(position).getCustomCategory().size() == 1) {
                fillFirstPor(context,position,holder);
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 2) {
                fillFirstPor(context,position,holder);
                fillSectPor(context,position,holder);
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 3) {
                fillFirstPor(context,position,holder);
                fillSectPor(context,position,holder);
                fillThertPor(context,position,holder);
            }
        }
    }

    private void fillThertPor(Context context, int position, ViewHolder holder) {
        int color = Color.parseColor("#2364C2");

        holder.cat_por2_position3_rl.setBackgroundColor(color);
    }

    private void fillSectPor(Context context, int position, ViewHolder holder) {
        int color = Color.parseColor("#2364C2");

        holder.cat_por1_position2_rl.setBackgroundColor(color);
        holder.cat_por2_position2_rl.setBackgroundColor(color);
    }

    private void fillFirstPor(Context context, int position, ViewHolder holder) {
        int color = Color.parseColor("#2364C2");

        holder.cat_por1_position1_rl.setBackgroundColor(color);
        holder.cat_por2_position1_rl.setBackgroundColor(color);

    }

    private void actionListenerToCard(ViewHolder holder, final Context context, final int position) {
        if (allCatArrayL.get(position).getCustomCategory().size() != 0) {
            if (allCatArrayL.get(position).getCustomCategory().size() == 1) {

                holder.cat_position1_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });

            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 2) {

                holder.cat_position1_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });

                holder.cat_position2_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });


            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 3) {
                holder.cat_position1_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });

                holder.cat_position2_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });

                holder.cat_position3_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("cat_name",allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());

                        Intent intent = new Intent(context, com.fashion.rest.view.activity.SubCategory.class);
                        intent.putExtras(bundle);
                        ((Activity)context).startActivity(intent);
                        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                    }
                });
            }
        }
    }

    private void fillText(ViewHolder holder, Context context, int position) {
        if (allCatArrayL.get(position).getCustomCategory().size() != 0) {
            if (allCatArrayL.get(position).getCustomCategory().size() == 1) {
                holder.custom_category_tv1_position1.setText(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 2) {
                holder.custom_category_tv1_position1.setText(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());
                holder.custom_category_tv2_position2.setText(allCatArrayL.get(position).getCustomCategory().get(1).getCategory_en());
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 3) {
                holder.custom_category_tv1_position1.setText(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_en());
                holder.custom_category_tv2_position2.setText(allCatArrayL.get(position).getCustomCategory().get(1).getCategory_en());
                holder.custom_category_tv2_position3.setText(allCatArrayL.get(position).getCustomCategory().get(2).getCategory_en());
            }
        }
    }

    private void changeFont(ViewHolder holder, Context context) {
        holder.custom_category_tv1_position1.setTypeface(Functions.changeFontGeneral(context));
        holder.custom_category_tv2_position2.setTypeface(Functions.changeFontGeneral(context));
        holder.custom_category_tv2_position3.setTypeface(Functions.changeFontGeneral(context));
    }

    private void fillImage(Context context, ViewHolder holder, int position) {

        if (allCatArrayL.get(position).getCustomCategory().size() != 0) {
            if (allCatArrayL.get(position).getCustomCategory().size() == 1) {
                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image1_position1);
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 2) {
                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image1_position1);

                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(1).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image2_position2);
            }
            if (allCatArrayL.get(position).getCustomCategory().size() == 3) {
                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(0).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image1_position1);

                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(1).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image2_position2);

                Picasso.get()
                        .load(allCatArrayL.get(position).getCustomCategory().get(2).getCategory_image())
                        .fit()
                        .centerCrop()
                        .into(holder.custom_category_image3_position3);
            }
        }
    }

    @Override
    public int getItemCount() {
        return allCatArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView custom_category_image1_position1,custom_category_image2_position2,custom_category_image3_position3;
        RelativeLayout cat_position1_rl,cat_position2_rl,cat_position3_rl;
        RelativeLayout cat_por1_position1_rl,cat_por2_position1_rl,cat_por1_position2_rl,cat_por2_position2_rl,cat_por2_position3_rl;
        TextView custom_category_tv1_position1,custom_category_tv2_position2,custom_category_tv2_position3;
        public ViewHolder(View itemView) {
            super(itemView);
            cat_position1_rl = (RelativeLayout) itemView.findViewById(R.id.cat_position1_rl) ;
            cat_position2_rl = (RelativeLayout) itemView.findViewById(R.id.cat_position2_rl) ;
            cat_position3_rl = (RelativeLayout) itemView.findViewById(R.id.cat_position3_rl) ;

            custom_category_image1_position1 = (ImageView) itemView.findViewById(R.id.custom_category_image1_position1) ;
            custom_category_image2_position2 = (ImageView) itemView.findViewById(R.id.custom_category_image2_position2) ;
            custom_category_image3_position3 = (ImageView) itemView.findViewById(R.id.custom_category_image3_position3) ;

            custom_category_tv1_position1 = (TextView) itemView.findViewById(R.id.custom_category_tv1_position1);
            custom_category_tv2_position2 = (TextView) itemView.findViewById(R.id.custom_category_tv2_position2);
            custom_category_tv2_position3 = (TextView) itemView.findViewById(R.id.custom_category_tv2_position3);

            cat_por1_position1_rl = (RelativeLayout) itemView.findViewById(R.id.cat_por1_position1_rl) ;
            cat_por2_position1_rl = (RelativeLayout) itemView.findViewById(R.id.cat_por2_position1_rl) ;

            cat_por1_position2_rl = (RelativeLayout) itemView.findViewById(R.id.cat_por1_position2_rl) ;
            cat_por2_position2_rl = (RelativeLayout) itemView.findViewById(R.id.cat_por2_position2_rl) ;

            cat_por2_position3_rl = (RelativeLayout) itemView.findViewById(R.id.cat_por2_position3_rl) ;

        }

    }

}