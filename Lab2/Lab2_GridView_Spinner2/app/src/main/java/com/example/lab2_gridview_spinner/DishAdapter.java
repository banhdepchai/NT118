package com.example.lab2_gridview_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends BaseAdapter {

    private Context context = null;
    private int layout;
    private List<Dish> dishes = null;

    public DishAdapter(Context context, int layout, List<Dish> dishes) {
        this.context = context;
        this.layout = layout;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_dish, null, false);
        }

        Dish dish = dishes.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.thumnail_iv_item);
        TextView txtMonan = (TextView) convertView.findViewById(R.id.name_tv_view_item);
        txtMonan.setSelected(true);
        ImageView icnStar = (ImageView) convertView.findViewById(R.id.promotion_iv_item);
        ImageView icnStarOutline = (ImageView) convertView.findViewById(R.id.promotion_iv_item_outline);

        if (dish.getPromotion())
        {
            icnStar.setVisibility(View.VISIBLE);
            icnStarOutline.setVisibility(View.GONE);
        }
        else
        {
            icnStar.setVisibility(View.GONE);
            icnStarOutline.setVisibility(View.VISIBLE);
        }

        imageView.setImageResource(dish.getThumbnail().getImg());
        txtMonan.setText(dish.getName());
        return convertView;
    }
}
