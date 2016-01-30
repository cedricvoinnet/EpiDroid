package com.example.jordan.epiandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jordan on 25/01/2016.
 */
public class Project implements Parcelable {
    private String name;
    private String comments;
    private String note;

    public Project(String name, String comments, String note) {
        this.name = name;
        this.comments = comments;
        this.note = note;
    }

    protected Project(Parcel in) {
        name = in.readString();
        comments = in.readString();
        note = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(comments);
        dest.writeString(note);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
