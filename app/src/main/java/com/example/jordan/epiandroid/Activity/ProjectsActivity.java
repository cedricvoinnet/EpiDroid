package com.example.jordan.epiandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.jordan.epiandroid.Adapter.ProjectsArrayAdapter;
import com.example.jordan.epiandroid.Models.ModuleItem;
import com.example.jordan.epiandroid.R;

public class ProjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Intent intent = getIntent();
        ModuleItem mi = (ModuleItem) intent.getParcelableExtra("module");
        ProjectsArrayAdapter adapter = new ProjectsArrayAdapter(this, R.layout.fragment_module, mi.getProjects(), this);
        ListView lvModule = (ListView) findViewById(R.id.lv_note);
        lvModule.setAdapter(adapter);
    }
}
