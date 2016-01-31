package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jordan.epiandroid.Models.DashBoard.History;
import com.example.jordan.epiandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NotifcationArrayAdapter extends ArrayAdapter<History> {
    private static LayoutInflater mInflater = null;
    private static List<History> objs;
    private Context context;

    public NotifcationArrayAdapter(Context context, int layout, List<History> objects) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final History current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_notification, parent, false);
        }
        if (current.getUser().getPicture() != null) {
            Log.d("DashBoard", current.getUser().getPicture().replace("userprofil/", "userprofil/profilview/").replace(".bmp", ".jpg"));
            ImageView picture = (ImageView) convertView.findViewById(R.id.iv_profile_picture);
            Picasso.with(context)
                    .load(current.getUser().getPicture().replace("userprofil/", "userprofil/profilview/").replace(".bmp", ".jpg"))
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.icon_dashboard)
                    .into(picture);
        }
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        tvContent.setText(android.text.Html.fromHtml(current.getTitle()));
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);
        tvDate.setText(current.getDate());


        return convertView;
    }
}