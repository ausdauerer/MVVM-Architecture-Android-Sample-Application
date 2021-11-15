package com.example.mvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView rv;
    private MainActivityViewModel mMainActivityViewModel;
    private MainActivityRecyclerViewAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_activity_recycler_view);
        progressBar=findViewById(R.id.recyclerViewProgressBar);
        fab=findViewById((R.id.refreshRecyclerViewFab));
        mMainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getData().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                adapter.notifyDataSetChanged();
            }
        });
        mMainActivityViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean==true){
                    showProgressBar();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Successfully Fetched data",Toast.LENGTH_LONG).show();
                    hideProgressBar();
                    rv.smoothScrollToPosition(mMainActivityViewModel.getData().getValue().size()-1);
                }
            }
        });
        initRecyclerView();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainActivityViewModel.refreshData();
            }
        });
    }
    public void initRecyclerView(){
        rv=findViewById(R.id.main_activity_recycler_view);
        adapter=new MainActivityRecyclerViewAdapter(this,mMainActivityViewModel.getData().getValue());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}