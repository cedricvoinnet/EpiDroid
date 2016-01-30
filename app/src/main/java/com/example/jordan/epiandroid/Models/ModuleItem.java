package com.example.jordan.epiandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordan on 25/01/2016.
 */
public class ModuleItem implements Parcelable {
    private String name;
    List<Project> projects;

    public ModuleItem(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    protected ModuleItem(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0x01) {
            projects = new ArrayList<Project>();
            in.readList(projects, Project.class.getClassLoader());
        } else {
            projects = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (projects == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(projects);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ModuleItem> CREATOR = new Parcelable.Creator<ModuleItem>() {
        @Override
        public ModuleItem createFromParcel(Parcel in) {
            return new ModuleItem(in);
        }

        @Override
        public ModuleItem[] newArray(int size) {
            return new ModuleItem[size];
        }
    };
}
