package com.paul.testannotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @AutoWire
    String name;
    @AutoWire
    int age;
    @AutoWire
    Person person;
    @AutoWire
    Person[] persons;
//    @AutoWire
//    PersonPer[] personsPer;

    @AutoWire
    PersonPer personPer;


    @AutoWire
    PersonPer[] personsPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyButterKnife.bind(this);
        Log.e("===","============"+name+"==="+age+"=="+person+"==="+persons+"=="+personPer+"==="+personsPer);
    }
}
