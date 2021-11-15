package com.example.mvvmexample;

import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* Singleton Pattern */
public class DataRepository{

    private static DataRepository instance;
    ArrayList<String> dataSet=new ArrayList<String>();

    public static DataRepository getInstance(){
        if(instance==null){
            instance=new DataRepository();
        }
        return(instance);
    }

    public MutableLiveData<ArrayList<String>> getData(){
        setData();
        MutableLiveData<ArrayList<String>> data=new MutableLiveData<ArrayList<String>>();
        data.setValue(dataSet);
        return(data);
    }

    // Data set by webserver
    private void setData(){
        dataSet.clear();
        dataSet.add("Hello");
        dataSet.add("My");
        dataSet.add("Name");
        dataSet.add("Is");
        dataSet.add("Rahul");
        dataSet.add("Dunkirk");
        dataSet.add("Enigma");
        dataSet.add("Hello");
        dataSet.add("My");
        dataSet.add("Name");
        dataSet.add("Is");
        dataSet.add("Rahul");
        dataSet.add("Dunkirk");
        dataSet.add("Enigma");
        dataSet.add("Hello");
        dataSet.add("My");
        dataSet.add("Name");
        dataSet.add("Is");
        dataSet.add("Rahul");
        dataSet.add("Dunkirk");
        dataSet.add("Enigma");
        dataSet.add("Hello");
        dataSet.add("My");
        dataSet.add("Name");
        dataSet.add("Is");
        dataSet.add("Rahul");
        dataSet.add("Dunkirk");
        dataSet.add("Enigma");
        dataSet.add("Hello");
        dataSet.add("My");
        dataSet.add("Name");
        dataSet.add("Is");
        dataSet.add("Rahul");
        dataSet.add("Dunkirk");
        dataSet.add("Enigma End");
    }
}
