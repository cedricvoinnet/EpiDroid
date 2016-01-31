package com.example.jordan.epiandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Activity.ProjectsActivity;
import com.example.jordan.epiandroid.Models.ModulesMarks.Items;
import com.example.jordan.epiandroid.Models.ModulesMarks.Module;
import com.example.jordan.epiandroid.Models.ModulesMarks.Modules;
import com.example.jordan.epiandroid.R;

import java.util.List;

public class ModuleArrayAdapter extends ArrayAdapter<Module> {
    private static LayoutInflater mInflater = null;
    private static List<Module> objs;
    private Context context;

    public ModuleArrayAdapter(Context context, int layout, List<Module> objects) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Module current = objs.get(position);
        if (convertView == null && mInflater != null)
            convertView = mInflater.inflate(R.layout.row_module, parent, false);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_module_name);
        tvName.setText(current.getTitle());
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] moduleInfo = new String[3];
                moduleInfo[0] = current.getGrade();
                moduleInfo[1] = Integer.toString(current.getCredits());
                moduleInfo[2] = current.getCodemodule();
                Intent intent = new Intent(context, ProjectsActivity.class);
                intent.putExtra("module", moduleInfo);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}