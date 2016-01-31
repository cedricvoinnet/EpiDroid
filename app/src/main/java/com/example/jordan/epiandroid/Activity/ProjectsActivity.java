package com.example.jordan.epiandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Adapter.ProjectsArrayAdapter;
import com.example.jordan.epiandroid.Models.ModulesMarks.Mark;
import com.example.jordan.epiandroid.Models.ModulesMarks.Marks;
import com.example.jordan.epiandroid.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProjectsActivity extends AppCompatActivity {
    private String[] moduleInfo;

    private TextView tvGrade;
    private TextView tvCredits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Intent intent = getIntent();
        moduleInfo = intent.getStringArrayExtra("module");

        tvGrade = (TextView) findViewById(R.id.tv_grade);
        tvGrade.setText(moduleInfo[0]);

        tvCredits = (TextView) findViewById(R.id.tv_credits);
        tvCredits.setText(moduleInfo[1]);

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.API_URL)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();

        APIRequest request = retrofit.create(APIRequest.class);

        Call<Marks> call = request.getMarks(MainActivity.sessionToken);
        call.enqueue(new Callback<Marks>() {
            @Override
            public void onResponse(Response<Marks> response) {
                Log.d("Marks", "Success");
                if (response.code() == 200) {
                    Marks marks = response.body();

                    setMarks(marks.getMarks());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Marks", "Fail => " + t.toString());
            }
        });
    }

    private void setMarks(List<Mark> marks) {
        if (getBaseContext() != null) {
            List<Mark> tmp = new ArrayList<>();

            for (Mark mark : marks)
                if (mark.getCodemodule().equals(moduleInfo[2]))
                    tmp.add(mark);

            ProjectsArrayAdapter adapter = new ProjectsArrayAdapter(this, R.layout.fragment_module, tmp, this);
            ListView lvModule = (ListView) findViewById(R.id.lv_note);
            lvModule.setAdapter(adapter);
        }
    }
}
