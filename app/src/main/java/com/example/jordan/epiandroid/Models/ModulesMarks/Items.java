package com.example.jordan.epiandroid.Models.ModulesMarks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    private Integer id;

    @SerializedName("title_cn")
    @Expose
    private Object titleCn;

    private Integer semester;

    private String num;

    private String begin;

    private String end;

    @SerializedName("end_register")
    @Expose
    private String endRegister;

    private Integer scolaryear;

    private String code;

    private String codeinstance;

    @SerializedName("location_title")
    @Expose
    private String locationTitle;

    @SerializedName("instance_location")
    @Expose
    private String instanceLocation;

    private String flags;

    private String credits;

    private String status;

    @SerializedName("waiting_grades")
    @Expose
    private Object waitingGrades;

    @SerializedName("active_promo")
    @Expose
    private String activePromo;

    private String open;

    @SerializedName("title")
    @Expose
    private String title;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The titleCn
     */
    public Object getTitleCn() {
        return titleCn;
    }

    /**
     * @param titleCn The title_cn
     */
    public void setTitleCn(Object titleCn) {
        this.titleCn = titleCn;
    }

    /**
     * @return The semester
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * @param semester The semester
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * @return The num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * @return The begin
     */
    public String getBegin() {
        return begin;
    }

    /**
     * @param begin The begin
     */
    public void setBegin(String begin) {
        this.begin = begin;
    }

    /**
     * @return The end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end The end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return The endRegister
     */
    public String getEndRegister() {
        return endRegister;
    }

    /**
     * @param endRegister The end_register
     */
    public void setEndRegister(String endRegister) {
        this.endRegister = endRegister;
    }

    /**
     * @return The scolaryear
     */
    public Integer getScolaryear() {
        return scolaryear;
    }

    /**
     * @param scolaryear The scolaryear
     */
    public void setScolaryear(Integer scolaryear) {
        this.scolaryear = scolaryear;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The codeinstance
     */
    public String getCodeinstance() {
        return codeinstance;
    }

    /**
     * @param codeinstance The codeinstance
     */
    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    /**
     * @return The locationTitle
     */
    public String getLocationTitle() {
        return locationTitle;
    }

    /**
     * @param locationTitle The location_title
     */
    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    /**
     * @return The instanceLocation
     */
    public String getInstanceLocation() {
        return instanceLocation;
    }

    /**
     * @param instanceLocation The instance_location
     */
    public void setInstanceLocation(String instanceLocation) {
        this.instanceLocation = instanceLocation;
    }

    /**
     * @return The flags
     */
    public String getFlags() {
        return flags;
    }

    /**
     * @param flags The flags
     */
    public void setFlags(String flags) {
        this.flags = flags;
    }

    /**
     * @return The credits
     */
    public String getCredits() {
        return credits;
    }

    /**
     * @param credits The credits
     */
    public void setCredits(String credits) {
        this.credits = credits;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The waitingGrades
     */
    public Object getWaitingGrades() {
        return waitingGrades;
    }

    /**
     * @param waitingGrades The waiting_grades
     */
    public void setWaitingGrades(Object waitingGrades) {
        this.waitingGrades = waitingGrades;
    }

    /**
     * @return The activePromo
     */
    public String getActivePromo() {
        return activePromo;
    }

    /**
     * @param activePromo The active_promo
     */
    public void setActivePromo(String activePromo) {
        this.activePromo = activePromo;
    }

    /**
     * @return The open
     */
    public String getOpen() {
        return open;
    }

    /**
     * @param open The open
     */
    public void setOpen(String open) {
        this.open = open;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
