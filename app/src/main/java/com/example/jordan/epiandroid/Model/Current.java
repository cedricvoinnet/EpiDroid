package com.example.jordan.epiandroid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Cedric on 28/01/2016.
 */
public class Current {

    @SerializedName("active_log")
    @Expose
    private String activeLog;

    /**
     * @return The active_log
     */
    public String getActiveLog() {
        return activeLog;
    }

    /**
     * @param activeLog The active_log
     */
    public void setActiveLog(String activeLog) {
        this.activeLog = activeLog;
    }
}
