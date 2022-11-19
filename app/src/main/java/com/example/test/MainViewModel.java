package com.example.test;

import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    RecyclerAdapter adapter;
    MutableLiveData<Boolean> observeToggle;
    MutableLiveData<ArrayList<String>> values;

    public void init() {
        observeToggle = new MutableLiveData<>(false);
        values = new MutableLiveData<>();

        ArrayList<String> val = getDummyData();
        values.setValue(val);

        adapter = new RecyclerAdapter(this);
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }

    public void toggleRecyclerView( ViewGroup stillView, View animatedView) {
        boolean show = Boolean.TRUE.equals(observeToggle.getValue());
        Transition transition = new Slide(Gravity.BOTTOM);
        transition.setDuration(600);
        transition.addTarget(animatedView);
        TransitionManager.beginDelayedTransition(stillView, transition);
        animatedView.setVisibility(show ? View.VISIBLE : View.GONE);
        observeToggle.postValue(!show);
    }

    public MutableLiveData<ArrayList<String>> getValues() {
        return values;
    }

    public ArrayList<String> getDummyData(){
        ArrayList<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");
        values.add("D");
        values.add("E");
        values.add("F");
        values.add("G");
        values.add("H");
        values.add("I");
        values.add("J");
        values.add("K");

        return values;
    }
}
