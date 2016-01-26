package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Activity.ProjectsActivity;
import com.example.jordan.epiandroid.Model.ModuleItem;
import com.example.jordan.epiandroid.R;

import java.util.List;

/**
 * Created by jordan on 25/01/2016.
 */
public class ModuleArrayAdapter extends ArrayAdapter<ModuleItem> {
    private static LayoutInflater mInflater = null;
    private static List<ModuleItem> objs;
    private Context context;

    public ModuleArrayAdapter(Context context, int layout, List<ModuleItem> objects) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        RelativeLayout fullRow;
        TextView tvName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final ModuleItem current = objs.get(position);
        if (convertView == null) {
            holder                      = new ViewHolder();
            convertView                 = mInflater.inflate(R.layout.row_module, parent, false);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_module_name);
            holder.tvName.setText(current.getName());
            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProjectsActivity.class);
                    intent.putExtra("module", current);
                    context.startActivity(intent);
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