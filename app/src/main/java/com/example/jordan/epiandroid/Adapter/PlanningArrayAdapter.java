package com.example.jordan.epiandroid.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Models.Planning.Activity;
import com.example.jordan.epiandroid.Models.PlanningItem;
import com.example.jordan.epiandroid.R;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.ButterKnife;

public class PlanningArrayAdapter extends ArrayAdapter<Activity> {
    private static LayoutInflater mInflater = null;
    private static List<Activity> objs;
    private Context context;
    private EditText token;

    public PlanningArrayAdapter(Context context, int layout, List<Activity> objects) {
        super(context, layout, objects);
        objs = objects;
        this.context = context;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        RelativeLayout fullRow;
        TextView tvName;
        TextView tvHour;
        TextView tvModule;
        TextView tvClassroom;
        Button      btnValidate;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Activity current = objs.get(position);
        if (convertView == null && mInflater != null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.row_planning, parent, false);

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvName.setText(current.getActiTitle());

            holder.tvHour = (TextView) convertView.findViewById(R.id.tv_hour);
            String start = current.getStart().split(" ")[1];
            String end = current.getEnd().split(" ")[1];
            String hour = start + " - " + end;
            holder.tvHour.setText(hour);

            holder.tvModule = (TextView) convertView.findViewById(R.id.tv_module);
            holder.tvModule.setText(current.getTitlemodule());

            holder.tvClassroom = (TextView) convertView.findViewById(R.id.tv_classroom);
            holder.tvClassroom.setText(current.getRoom() != null ? current.getRoom().getCode() : "N/A");

            Log.d("Planning", "Registered: " + current.getEventRegistered());
            holder.btnValidate = (Button) convertView.findViewById(R.id.b_validate_token);
            if (!current.getEventRegistered())
                holder.btnValidate.setVisibility(View.INVISIBLE);
            else {
                holder.btnValidate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.dialog_token);
                        token = (EditText) dialog.findViewById(R.id.et_token);
                        Button btnValidate = (Button) dialog.findViewById(R.id.btn_validate);
                        btnValidate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.v("PlanningAdapter", "on validate token button listener, token = " + token.getText());
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });
            }

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
