package com.example.jordan.epiandroid.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.epiandroid.Models.ModulesMarks.Mark;
import com.example.jordan.epiandroid.R;

import java.util.List;

/**
 * Created by jordan on 26/01/2016.
 */
public class ProjectsArrayAdapter extends ArrayAdapter<Mark> {
    private static LayoutInflater mInflater = null;
    private static List<Mark> objs;
    private Context context;
    private Activity activity;
    //private View view;

    public ProjectsArrayAdapter(Context context, int layout, List<Mark> objects, Activity activity) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        this.activity = activity;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Mark current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_project, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(current.getTitle());

        TextView tvNote = (TextView) convertView.findViewById(R.id.tv_note);
        tvNote.setText(current.getFinalNote());

        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("onclickProject", "ON CLICK");
                Dialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_project, null);

                builder.setView(dialogView);
                TextView comments = (TextView) dialogView.findViewById(R.id.tv_comments);
                comments.setText(current.getComment());

                    /*Intent intent = new Intent(context, ProjectsActivity.class);
                    intent.putExtra("module", current);
                    context.startActivity(intent);*/
                dialog = builder.create();
                dialog.show();
            }
        });
        return convertView;
    }
}