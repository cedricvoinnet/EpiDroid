package com.example.jordan.epiandroid.Models.ModulesMarks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Marks {
    @JsonProperty("notes")
    private List<Mark> marks;

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
