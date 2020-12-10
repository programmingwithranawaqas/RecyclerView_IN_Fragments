package com.wtechweb.v2_rv_fragments;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;

public class MyApplication extends Application {
    public static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("Afaq","03234567891"));
        people.add(new Person("Waqas","0323453211"));
        people.add(new Person("Mano","03234521312"));
        people.add(new Person("Sherry","03234511111"));
    }
}
