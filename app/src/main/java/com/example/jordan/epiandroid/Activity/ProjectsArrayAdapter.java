package com.example.jordan.epiandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Model.Project;
import com.example.jordan.epiandroid.R;

import java.util.List;

/**
 * Created by jordan on 26/01/2016.
 */
public class ProjectsArrayAdapter extends ArrayAdapter<Project> {
    private static LayoutInflater mInflater = null;
    private static List<Project> objs;
    private Context context;

    public ProjectsArrayAdapter(Context context, int layout, List<Project> objects) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        RelativeLayout fullRow;
        TextView tvName;
        TextView tvNote;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Project current = objs.get(position);
        if (convertView == null) {
            holder                      = new ViewHolder();
            convertView                 = mInflater.inflate(R.layout.row_project, parent, false);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvName.setText(current.getName());
            holder.tvNote = (TextView) convertView.findViewById(R.id.tv_note);
            holder.tvNote.setText(current.getNote());
            holder.fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
            holder.fullRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(context, ProjectsActivity.class);
                    intent.putExtra("module", current);
                    context.startActivity(intent);*/
                }
            });
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}