package com.example.jordan.epiandroid.Models;

import android.graphics.Color;

/**
 * Created by jordan on 25/01/2016.
 */
public class PlanningItem {
    private String name;
    private String hour;
    private String module;
    private String classroom;
    private Color color;

    public PlanningItem(String name, String hour, String module, String classroom) {
        this.name = name;
        this.hour = hour;
        this.module = module;
        this.classroom = classroom;
        //this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
