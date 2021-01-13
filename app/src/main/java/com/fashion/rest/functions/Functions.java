package com.fashion.rest.functions;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.fashion.rest.R;
import com.fashion.rest.model.Category;
import com.fashion.rest.model.Deal;
import com.fashion.rest.model.FastFood;
import com.fashion.rest.model.Notification;
import com.fashion.rest.model.OffersGradientsWithTextColor;
import com.fashion.rest.model.Price;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.fashion.rest.sharedPreferences.Language.getLanguageFromSP;

public class Functions {
    private static final int PAGE_SIZEH = 8;

    public static int nowNumberOfObject(int x , int y) {
        int z =0;
        if (y ==0)
        {
            z =0;
        }else{
            if (y > PAGE_SIZEH)
            {
                if (x >= y)
                {
                    z =1000;
                }else {
                    int d = y - x;
                    if (d >= PAGE_SIZEH)
                    {
//                        Log.i("TAG","x = x+10");
                        z =PAGE_SIZEH;
                    }else {
//                        Log.i("TAG","x = x+d");
                        z =d;
                    }
                }
            }else {
                z =y;
            }
        }
        return z;
    }

    public static double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(d));
    }

    public static Typeface changeFontAppName(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "Pacifico.ttf");
        return typeFace;
    }

    public static Typeface changeFontGeneral(Context context) {
        Typeface typeFace =null;
        if (getLanguageFromSP(context) != null && getLanguageFromSP(context).equals("ar")) {
            typeFace = Typeface.createFromAsset(context.getAssets(), "GE_DINAR_ONE_LIGHT.TTF");
        }else{
            typeFace = Typeface.createFromAsset(context.getAssets(), "NTAILU.TTF");
        }
        return typeFace;
    }

    public static Typeface changeFontCategory(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "Orbitron.TTF");
        return typeFace;
    }

    public static Typeface changeFontOrbitronBold(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "OrbitronBold.TTF");
        return typeFace;
    }

    public static Typeface changeFontToArabic(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "GE_DINAR_ONE_LIGHT.TTF");
        return typeFace;
    }

    public static ArrayList<Category> fillOptionsArrayL(ArrayList<Category> categoryArrayL, Context context) {
        categoryArrayL = new ArrayList<Category>();

        Category category1 = new Category(context.getResources().getString(R.string.set),R.drawable.m1);
        Category category2 = new Category(context.getResources().getString(R.string.bracelets),R.drawable.m2);
        Category category3 = new Category(context.getResources().getString(R.string.necklaces),R.drawable.m3);
        Category category4 = new Category(context.getResources().getString(R.string.rings),R.drawable.m4);
        Category category5 = new Category(context.getResources().getString(R.string.foot_anklet),R.drawable.m5);
        Category category6 = new Category(context.getResources().getString(R.string.earring),R.drawable.m6);


        categoryArrayL.add(category1);
        categoryArrayL.add(category2);
        categoryArrayL.add(category3);
        categoryArrayL.add(category4);
        categoryArrayL.add(category5);
        categoryArrayL.add(category6);

        return categoryArrayL;
    }

    public static ArrayList<String> fillMeanArrayL(ArrayList<String> meanArrayL, Context context) {
        meanArrayL = new ArrayList<String>();


        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("ff");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");
        meanArrayL.add("res");

        return meanArrayL;
    }


    public static ArrayList<FastFood> fillFastFoodArrayL(ArrayList<FastFood> fastFoodArrayL, Context context) {
        fastFoodArrayL = new ArrayList<FastFood>();

        FastFood fastFood1 = new FastFood(context.getResources().getString(R.string.bg),"15",R.drawable.burger_king);
        FastFood fastFood2 = new FastFood(context.getResources().getString(R.string.macdonalds),"15",R.drawable.mcdonalds);
        FastFood fastFood3 = new FastFood(context.getResources().getString(R.string.hardees),"15",R.drawable.hardess);
        FastFood fastFood7 = new FastFood(context.getResources().getString(R.string.dominos),"15",R.drawable.dom);
        FastFood fastFood4 = new FastFood(context.getResources().getString(R.string.kfc),"15",R.drawable.kfc);
        FastFood fastFood5 = new FastFood(context.getResources().getString(R.string.pizza_h),"15",R.drawable.pizz_h);
        FastFood fastFood6 = new FastFood(context.getResources().getString(R.string.subway),"15",R.drawable.subway);

        fastFoodArrayL.add(fastFood1);
        fastFoodArrayL.add(fastFood2);
        fastFoodArrayL.add(fastFood3);
        fastFoodArrayL.add(fastFood4);
        fastFoodArrayL.add(fastFood5);
        fastFoodArrayL.add(fastFood6);

        return fastFoodArrayL;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static ArrayList<Deal> fillSetArrayL(ArrayList<Deal> dealArrayL, Context context) {
        dealArrayL = new ArrayList<Deal>();

        OffersGradientsWithTextColor offersGradientsWithTextColor = new OffersGradientsWithTextColor("roseanna",context.getColor(R.color.colorBlack));

        String image = "https://firebasestorage.googleapis.com/v0/b/restaurant-31ab3.appspot.com/o/meal_image%2Fms.jpg?alt=media&token=9d6bb813-8dce-4785-ae83-c1a9e268b3f2";
        Price price1 = new Price(180,99,180);
        Price price2 = new Price(170,99,170);
        Price price3 = new Price(160,99,160);

        Deal deal1 = new Deal(R.drawable.s2,image,context.getResources().getString(R.string.QiaoKai),context.getResources().getString(R.string.QiaoKai_des),price1,offersGradientsWithTextColor);
        Deal deal2 = new Deal(R.drawable.s3,image,context.getResources().getString(R.string.Embellished),context.getResources().getString(R.string.Embellished_des),price2,offersGradientsWithTextColor);
        Deal deal3 = new Deal(R.drawable.s1,image,context.getResources().getString(R.string.Jewellery),context.getResources().getString(R.string.Jewellery_des),price3,offersGradientsWithTextColor);

        dealArrayL.add(deal1);
        dealArrayL.add(deal2);
        dealArrayL.add(deal3);
        dealArrayL.add(deal1);
        dealArrayL.add(deal2);
        dealArrayL.add(deal3);
        dealArrayL.add(deal1);
        dealArrayL.add(deal2);
        dealArrayL.add(deal3);
        dealArrayL.add(deal1);
        dealArrayL.add(deal2);
        dealArrayL.add(deal3);
        dealArrayL.add(deal1);
        dealArrayL.add(deal2);
        dealArrayL.add(deal3);

        return dealArrayL;
    }

    public static ArrayList<String> fillImgArrayL() {
        ArrayList<String> ImgArrayL = new ArrayList<String>();

        String image = "https://firebasestorage.googleapis.com/v0/b/restaurant-31ab3.appspot.com/o/meal_image%2Fms.jpg?alt=media&token=9d6bb813-8dce-4785-ae83-c1a9e268b3f2";
        String image1 ="https://firebasestorage.googleapis.com/v0/b/test-c434c.appspot.com/o/Screen%20Shot%202020-10-22%20at%2012.28.40%20PM.pn" +
                "g?alt=media&token=9bb719a5-ccae-492f-9091-db5a0c559465";
        String image2 = "https://firebasestorage.googleapis.com/v0/b/test-c434c.appspot.com/o/Screen%20Shot%202020-10-22%20at%2012.29" +
                ".01%20PM.png?alt=media&token=9c0f6a72-5fdd-4151-a37b-fba462b8fd16";
        String image3 = "https://firebasestorage.googleapis.com/v0/b/test-c434c.appspot.com/o/Screen%20Shot%202020-10-22%20at%2012.28.16%20PM.png?alt=media&token=16b5e6ff-8ab9-4af7-b764-3eeb44159bcf";
        String image4 = "https://firebasestorage.googleapis.com/v0/b/test-c434c.appspot.com/o/Screen%20Shot%202020-10-22%20at%2012.29.12%20PM.png?alt=media&token=88b6f628-4878-4e05-8f89-c876c3fc4205";
        ImgArrayL.add(image1);
        ImgArrayL.add(image3);
        ImgArrayL.add(image4);

        return ImgArrayL;
    }

    public static ArrayList<Notification> fillNotificationsArrayL(Context context) {
        ArrayList<Notification> notificationArrayL = new ArrayList<Notification>();

        String image1 ="https://firebasestorage.googleapis.com/v0/b/test-c434c.appspot.com/o/Screen%20Shot%202020-10-22%20at%2012.28.40%20PM.pn" +
                "g?alt=media&token=9bb719a5-ccae-492f-9091-db5a0c559465";

        Notification notification = new Notification(
                "1",context.getResources().getString(R.string.title1),context.getResources().getString(R.string.title1_des),image1,"test","test","18/10/2020","Bracelets"
        );

        Notification notification2 = new Notification(
                "1",context.getResources().getString(R.string.title2),context.getResources().getString(R.string.title2_des),image1,"test","test","18/10/2020","Bracelets"
        );

        Notification notification3 = new Notification(
                "0",context.getResources().getString(R.string.title3),context.getResources().getString(R.string.title3_des),image1,"test","test","18/10/2020","Bracelets"
        );

        Notification notification4 = new Notification(
                "0",context.getResources().getString(R.string.title4),context.getResources().getString(R.string.title4_des),image1,"test","test","18/10/2020","Bracelets"
        );

        Notification notification5 = new Notification(
                "1",context.getResources().getString(R.string.title5),context.getResources().getString(R.string.title5_des),image1,"test","test","18/10/2020","Bracelets"
        );
        Notification notification6 = new Notification(
                "1",context.getResources().getString(R.string.title6),context.getResources().getString(R.string.title6_des),image1,"test","test","18/10/2020","Bracelets"
        );


        notificationArrayL.add(notification);
        notificationArrayL.add(notification2);
        notificationArrayL.add(notification3);
        notificationArrayL.add(notification4);
        notificationArrayL.add(notification5);
        notificationArrayL.add(notification6);

        return notificationArrayL;
    }

    public static Typeface changeFontBold(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "NTAILUB.TTF");
        return typeFace;
    }
}
