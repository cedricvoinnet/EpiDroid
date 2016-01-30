package com.example.jordan.epiandroid.Models.Planning;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("seats")
    @Expose
    private Integer seats;
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The seats
     */
    public Integer getSeats() {
        return seats;
    }

    /**
     * @param seats The seats
     */
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

}