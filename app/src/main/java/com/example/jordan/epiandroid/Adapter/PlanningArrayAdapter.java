package com.example.jordan.epiandroid.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Activity.MainActivity;
import com.example.jordan.epiandroid.Models.Planning.Activity;
import com.example.jordan.epiandroid.Models.Token.Token;
import com.example.jordan.epiandroid.R;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Activity current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_planning, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(current.getActiTitle());

        TextView tvHour = (TextView) convertView.findViewById(R.id.tv_hour);
        String start = current.getStart().split(" ")[1];
        start = start.substring(0, start.length() - 3);
        String end = current.getEnd().split(" ")[1];
        end = end.substring(0, end.length() - 3);
        String hour = start + " - " + end;
        tvHour.setText(hour);

        TextView tvModule = (TextView) convertView.findViewById(R.id.tv_module);
        tvModule.setText(current.getTitlemodule());

        TextView tvClassroom = (TextView) convertView.findViewById(R.id.tv_classroom);
        tvClassroom.setText(current.getRoom() != null ? current.getRoom().getCode() : "N/A");

        Button btnValidate = (Button) convertView.findViewById(R.id.b_validate_token);
        if (current.getEventRegistered().equals("registered") && current.getAllowToken())
            btnValidate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_token);
                    token = (EditText) dialog.findViewById(R.id.et_token);
                    Button btnValidate = (Button) dialog.findViewById(R.id.btn_validate);
                    btnValidate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (token.getText().length() == 8) {
                                Log.v("PlanningAdapter", "on validate token button listener, token = " + token.getText());

                                Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(MainActivity.API_URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

                                APIRequest request = retrofit.create(APIRequest.class);
                                Call<Token> call = request.postToken(MainActivity.sessionToken,
                                        current.getScolaryear(),
                                        current.getCodemodule(),
                                        current.getCodeinstance(),
                                        current.getCodeacti(), current.getCodeevent(),
                                        token.getText().toString());

                                call.enqueue(new Callback<Token>() {
                                    @Override
                                    public void onResponse(Response<Token> response) {
                                        Log.d("Token", "code: " + response.code());
                                        Token r = response.body();

                                        if (r.getError() != null)
                                            Toast.makeText(context, r.getError(), Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Throwable t) {
                                        Toast.makeText(context, R.string.network_error, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else
                                Toast.makeText(context, R.string.wrong_token_format, Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.show();
                }
            });
        else {
            btnValidate.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }
}
