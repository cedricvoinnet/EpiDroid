package com.example.jordan.epiandroid.Models.ModulesMarks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Modules {
    @JsonProperty("modules")
    private List<Module> modules;

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
