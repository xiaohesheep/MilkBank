package com.android.androiddemo.model;

import java.io.Serializable;

/**
 * Discription:
 * Created by guokun on 2020/5/11.
 */
public class MyModel implements Serializable {
    private static final long serialVersionUID = -2918288899774460899L;

    public String title;
    public String name;
    public String dis;

    public MyModel(String title, String name, String dis) {
        this.title = title;
        this.name = name;
        this.dis = dis;
    }
}
