package com.example.lab2_gridview_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Context context;

    public ThumbnailAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Thumbnail[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, null, false);
        }


        TextView tvName = convertView.findViewById(R.id.tv_item_thumbnail);
        ImageView imageView = convertView.findViewById(R.id.img_item_thumbnail);
        Thumbnail thumbnail = getItem(position);
        tvName.setText(thumbnail.getName());
        imageView.setImageResource(thumbnail.getImg());
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Thumbnail thumbnail = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected, null, false);
        }
        ((TextView) convertView).setText(thumbnail.getName());
        return convertView;
    }
}
