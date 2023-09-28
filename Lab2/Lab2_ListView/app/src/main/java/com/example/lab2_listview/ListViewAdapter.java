package com.example.lab2_listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ListViewAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        //Cần trả về số phần tử mà ListView hiện thị
        return 0;
    }

    @Override
    public Object getItem(int position) {
        //Cần trả về đối tượng dữ liệu phần tử ở vị trí position
        return null;
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID liên quan đến phần tử ở vị trí position
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View hiện thị phần tử, nếu là null cần tạo mới
        //(có thể nạp từ layout bằng View.inflate)

        //Cuối cùng là gán dữ liệu ở vị trí possition vào View và trả về đối
        //tượng View này

        return null;
    }
}
