package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Models.Planning.Activity;
import com.example.jordan.epiandroid.Models.PlanningItem;
import com.example.jordan.epiandroid.R;

import java.util.List;

public class PlanningArrayAdapter extends ArrayAdapter<Activity> {
    private static LayoutInflater mInflater = null;
    private static List<Activity> objs;

    public PlanningArrayAdapter(Context context, int layout, List<Activity> objects) {
        super(context, layout, objects);
        objs = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        RelativeLayout fullRow;
        TextView tvName;
        TextView tvHour;
        TextView tvModule;
        TextView tvClassroom;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Activity current = objs.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.row_planning, parent, false);

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvName.setText(current.getActiTitle());

            holder.tvHour = (TextView) convertView.findViewById(R.id.tv_hour);
            holder.tvHour.setText(current.getStart());

            holder.tvModule = (TextView) convertView.findViewById(R.id.tv_module);
            holder.tvModule.setText(current.getTitlemodule());

            holder.tvClassroom = (TextView) convertView.findViewById(R.id.tv_classroom);
            holder.tvClassroom.setText(current.getRoom() != null ? current.getRoom().getCode() : "N/A");

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
