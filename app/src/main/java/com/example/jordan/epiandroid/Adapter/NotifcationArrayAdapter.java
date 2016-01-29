package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jordan.epiandroid.Models.DashBoard.History;
import com.example.jordan.epiandroid.R;

import java.util.List;

/**
 * Created by jordan on 26/01/2016.
 */
public class NotifcationArrayAdapter extends ArrayAdapter<History> {
    private static LayoutInflater mInflater = null;
    private static List<History> objs;
    private Context context;

    public NotifcationArrayAdapter(Context context, int layout, List<History> objects) {
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
        final History current = objs.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.row_notification, parent, false);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            holder.tvContent.setText(android.text.Html.fromHtml(current.getTitle()));
            holder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tvDate.setText(current.getDate());

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}