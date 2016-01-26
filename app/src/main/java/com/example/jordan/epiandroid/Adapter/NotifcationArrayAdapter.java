package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Activity.ProjectsActivity;
import com.example.jordan.epiandroid.Model.ModuleItem;
import com.example.jordan.epiandroid.Model.Notification;
import com.example.jordan.epiandroid.R;

import java.util.List;

/**
 * Created by jordan on 26/01/2016.
 */
public class NotifcationArrayAdapter extends ArrayAdapter<Notification> {
    private static LayoutInflater mInflater = null;
    private static List<Notification> objs;
    private Context context;

    public NotifcationArrayAdapter(Context context, int layout, List<Notification> objects) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        ImageView picture;
        TextView tvContent;
        TextView tvDate;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Notification current = objs.get(position);
        if (convertView == null) {
            holder                      = new ViewHolder();
            convertView                 = mInflater.inflate(R.layout.row_notification, parent, false);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            holder.tvContent.setText(current.getContent());
            holder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tvDate.setText(current.getDate());

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}