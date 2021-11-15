package com.example.mvvmexample;

import android.os.Handler;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> mData;
    private MutableLiveData<Boolean> isUpdating=new MutableLiveData<Boolean>();
    private DataRepository mRepo;

    public void init(){
        if(mData!=null){
            return;
        }
        mRepo=DataRepository.getInstance();
        mData=mRepo.getData();
    }

    public void refreshData(){
        isUpdating.setValue(true);

        ArrayList<String> fetchedData=mRepo.getData().getValue();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mData.setValue(fetchedData);
                isUpdating.setValue(false);
            }
        }, 2000);   //5 seconds
    }
    public LiveData<ArrayList<String>> getData(){
        return(mData);
    }
    public LiveData<Boolean> getIsLoading(){
        return(isUpdating);
    }
}
