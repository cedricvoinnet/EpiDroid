package com.example.jordan.epiandroid.Fragment.PlanningFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Model.PlanningItem;
import com.example.jordan.epiandroid.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jordan on 25/01/2016.
 */
public class PlanningArrayAdapter extends ArrayAdapter<PlanningItem>{
    private static LayoutInflater mInflater = null;
    private static List<PlanningItem> objs;

    public PlanningArrayAdapter(Context context, int layout, List<PlanningItem> objects) {
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
        final PlanningItem current = objs.get(position);
        if (convertView == null) {
            holder                      = new ViewHolder();
            convertView                 = mInflater.inflate(R.layout.row_planning, parent, false);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvHour = (TextView) convertView.findViewById(R.id.tv_hour);
            holder.tvModule = (TextView) convertView.findViewById(R.id.tv_module);
            holder.tvClassroom = (TextView) convertView.findViewById(R.id.tv_classroom);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
