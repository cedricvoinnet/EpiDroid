package com.example.jordan.epiandroid.Models.ModulesMarks;

import java.util.ArrayList;
import java.util.List;

public class AllModules {
    List<Items> items = new ArrayList<>();

    /**
     * @return The items
     */
    public List<Items> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Items> items) {
        this.items = items;
    }

}