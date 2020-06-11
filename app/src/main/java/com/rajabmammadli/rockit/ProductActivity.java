package com.rajabmammadli.rockit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.rajabmammadli.rockit.Adapters.FitAdapter;
import com.rajabmammadli.rockit.Adapters.ProductSliderAdapter;
import com.rajabmammadli.rockit.Adapters.RecentAdapter;
import com.rajabmammadli.rockit.Models.FitModel;
import com.rajabmammadli.rockit.Models.RecentModel;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class ProductActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private ProductSliderAdapter productSliderAdapter;

    Button colorImgBg;
    ImageButton backBtn;

    ImageView mProductSlideImage;
    TextView mProductName;
    TextView mProductPrice;
    TextView mStoreName;

    RecyclerView fitTogetherRecyclerView;
    RecyclerView recentlyViewedRecyclerView;

    ArrayList<FitModel> fitModelArrayList;
    ArrayList<RecentModel> recentModelArrayList;
    FitAdapter fitAdapter;
    RecentAdapter recentAdapter;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        final MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.sizeSpinner);
        spinner.setItems("35", "36", "37", "38", "39", "40", "41", "42", "43");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                spinner.setText(item);
            }
        });

        mProductSlideImage = findViewById(R.id.product_slide_image);
        mProductName = findViewById(R.id.productName);
        mProductPrice = findViewById(R.id.productPrice);
        mStoreName = findViewById(R.id.storeName);

        colorImgBg = findViewById(R.id.colorImgBg);
        backBtn = findViewById(R.id.backBtn);

        fitTogetherRecyclerView = findViewById(R.id.fitTogetherRecyclerView);
        recentlyViewedRecyclerView = findViewById(R.id.recentlyViewedRecyclerView);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

        Bundle bundle = getIntent().getExtras();
        Integer productImage = bundle.getInt("productImage");
        String productName = bundle.getString("productName");
        String storeName = bundle.getString("storeName");
        String priceList = bundle.getString("priceList");

        //mProductSlideImage.setImageResource(productImage);
        mProductName.setText(productName);
        mStoreName.setText(storeName);
        mProductPrice.setText(priceList);

        productSliderAdapter = new ProductSliderAdapter(this);

        mSlideViewPager.setAdapter(productSliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mSlideViewPager.setOffscreenPageLimit(4);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        colorImgBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPicker colorPicker = new ColorPicker(ProductActivity.this);
                colorPicker.setTitle("Available colors:");
                colorPicker.show();
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position,int color) {

                    }

                    @Override
                    public void onCancel(){
                        // put code
                    }
                });
            }
        });

        Integer[] productPhoto = {R.drawable.nikesneaker, R.drawable.honeybottle, R.drawable.book, R.drawable.tshirt, R.drawable.samsungphone};
        Integer[] recentProductPhoto = {R.drawable.samsungphone, R.drawable.book, R.drawable.tshirt, R.drawable.nikesneaker, R.drawable.honeybottle};

        recentModelArrayList = new ArrayList<>();
        for (int i = 0; i < recentProductPhoto.length; i++) {
            RecentModel model = new RecentModel(recentProductPhoto[i]);
            recentModelArrayList.add(model);
        }

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(ProductActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecyclerView.setLayoutManager(layoutManager1);
        recentlyViewedRecyclerView.setItemAnimator(new DefaultItemAnimator());

        recentAdapter = new RecentAdapter(recentModelArrayList, ProductActivity.this);
        recentlyViewedRecyclerView.setAdapter(recentAdapter);

        fitModelArrayList = new ArrayList<>();
        for (int i = 0; i < productPhoto.length; i++) {
            FitModel model = new FitModel(productPhoto[i]);
            fitModelArrayList.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductActivity.this, LinearLayoutManager.HORIZONTAL, false);
        fitTogetherRecyclerView.setLayoutManager(layoutManager);
        fitTogetherRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fitAdapter = new FitAdapter(fitModelArrayList, ProductActivity.this);
        fitTogetherRecyclerView.setAdapter(fitAdapter);

    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#9673"));
            mDots[i].setTextSize(25);
            mDots[i].setPaddingRelative(0,0,15,0);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.colorBlue));

        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            mCurrentPage = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}