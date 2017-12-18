package com.itsgaurav.html5easy.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationUtils;

import com.itsgaurav.html5easy.R;
import com.itsgaurav.html5easy.adapters.MainAdapter;
import com.itsgaurav.html5easy.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import static com.itsgaurav.html5easy.AppConstants.htmlListItems;


public class MainActivity extends BaseActivity {

    private List<MainModel> mDataList = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtain reference of views
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        //initialize this screen
        initScreen(recyclerView);
    }

    /**
     * Method to initialize view for this screen.
     */
    private void initScreen(RecyclerView recyclerView) {
        //Initialize data
        initData();
        //Apply 'Slide Up' animation
        int resId = R.anim.layout_animation_from_bottom;
        //Set layout animation
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this, resId));
        //Set layout manger for recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(mDataList, this));
    }

    /**
     * Method to initialize data for recyclerView.
     */
    private void initData() {
        for (int i = 0; i < htmlListItems.length; i++) {
            MainModel model = new MainModel();
            model.setTitleText(htmlListItems[i]);
            model.setPosition(i);
            mDataList.add(model);
        }
    }
}
