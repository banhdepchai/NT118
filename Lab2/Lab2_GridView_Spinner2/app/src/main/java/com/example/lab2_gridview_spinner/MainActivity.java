package com.example.lab2_gridview_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner thumbnailSpinner;
    ThumbnailAdapter thumbnailAdapter;
    GridView gridView;
    DishAdapter dishAdapter;
    List<Dish> dishes = new ArrayList<>();
    EditText editTextName;
    CheckBox checkBoxPromotion;
    Button addDish;

    private Thumbnail[] thumbnails = new Thumbnail[] {Thumbnail.Thumbnail1, Thumbnail.Thumbnail2, Thumbnail.Thumbnail3, Thumbnail.Thumbnail4};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbnailSpinner = findViewById(R.id.sp_thumbnail);
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, R.layout.item_selected, thumbnails);

        thumbnailSpinner.setAdapter(thumbnailAdapter);

        gridView = findViewById(R.id.gv_dishes);
        dishAdapter = new DishAdapter(this, R.layout.gridview_dish, dishes);
        gridView.setAdapter(dishAdapter);

        editTextName = (EditText) findViewById(R.id.et_name);
        checkBoxPromotion = (CheckBox) findViewById(R.id.cbx_check_promotion);

        addDish = findViewById(R.id.btn_add);

        addDish.setOnClickListener((view) -> {
            Dish dish = new Dish(editTextName.getText().toString(), thumbnails[thumbnailSpinner.getSelectedItemPosition()], checkBoxPromotion.isChecked());
            dishes.add(dish);
            dishAdapter.notifyDataSetChanged();
            editTextName.setText("");
            thumbnailSpinner.setSelection(0);
            checkBoxPromotion.setChecked(false);
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        });
    }
}