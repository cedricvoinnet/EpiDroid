package com.example.jordan.epiandroid.Models.DashBoard;

import java.util.ArrayList;
import java.util.List;

public class DashInfos {

    private String ip;
    private List<History> history = new ArrayList<>();
    private Infos         infos;
    private List<Current> current = new ArrayList<>();

    /**
     * @return The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return The history
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * @param history The history
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

    /**
     * @return The current
     */
    public List<Current> getCurrent() {
        return current;
    }

    /**
     * @param current The current
     */
    public void setCurrent(List<Current> current) {
        this.current = current;
    }

    public Infos getInfos() {
        return infos;
    }

    public void setInfos(Infos infos) {
        this.infos = infos;
    }
}
