package com.example.jordan.epiandroid.Models.Planning;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("allow_register")
    @Expose
    private Boolean allowRegister;

    @SerializedName("codeinstance")
    @Expose
    private String codeinstance;

    @SerializedName("acti_title")
    @Expose
    private String actiTitle;

    @SerializedName("allow_token")
    @Expose
    private Boolean allowToken;

    @SerializedName("register_month")
    @Expose
    private Boolean registerMonth;

    private String codeacti;

    @SerializedName("module_registered")
    @Expose
    private Boolean moduleRegistered;

    @SerializedName("codemodule")
    @Expose
    private String codemodule;

    @SerializedName("register_prof")
    @Expose
    private Boolean registerProf;

    @SerializedName("prof_inst")
    @Expose
    private Object profInst;

    @SerializedName("register_student")
    @Expose
    private Boolean registerStudent;

    @SerializedName("allowed_planning_start")
    @Expose
    private String allowedPlanningStart;

    @SerializedName("rdv_indiv_registered")
    @Expose
    private Object rdvIndivRegistered;

    @SerializedName("rdv_group_registered")
    @Expose
    private Object rdvGroupRegistered;

    @SerializedName("project")
    @Expose
    private Boolean project;

    @SerializedName("module_available")
    @Expose
    private Boolean moduleAvailable;

    @SerializedName("titlemodule")
    @Expose
    private String titlemodule;

    @SerializedName("type_title")
    @Expose
    private String typeTitle;

    @SerializedName("type_code")
    @Expose
    private String typeCode;

    @SerializedName("nb_group")
    @Expose
    private Integer nbGroup;

    @SerializedName("num_event")
    @Expose
    private Integer numEvent;

    @SerializedName("semester")
    @Expose
    private Integer semester;

    @SerializedName("room")
    @Expose
    private Room room;

    @SerializedName("allowed_planning_end")
    @Expose
    private String allowedPlanningEnd;

    @SerializedName("scolaryear")
    @Expose
    private String scolaryear;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("codeevent")
    @Expose
    private String codeevent;

    @SerializedName("in_more_than_one_month")
    @Expose
    private Boolean inMoreThanOneMonth;

    @SerializedName("nb_hours")
    @Expose
    private String nbHours;

    @SerializedName("display")
    @Expose
    private String display;

    @SerializedName("dates")
    @Expose
    private Object dates;

    @SerializedName("nb_max_students_projet")
    @Expose
    private Object nbMaxStudentsProjet;

    @SerializedName("is_rdv")
    @Expose
    private String isRdv;

    @SerializedName("instance_location")
    @Expose
    private String instanceLocation;

    @SerializedName("title")
    @Expose
    private Object title;

    @SerializedName("event_registered")
    @Expose
    private Boolean eventRegistered;

    @SerializedName("end")
    @Expose
    private String end;

    @SerializedName("past")
    @Expose
    private Boolean past;

    @SerializedName("total_students_registered")
    @Expose
    private Integer totalStudentsRegistered;

    /**
     * @return The allowRegister
     */
    public Boolean getAllowRegister() {
        return allowRegister;
    }

    /**
     * @param allowRegister The allow_register
     */
    public void setAllowRegister(Boolean allowRegister) {
        this.allowRegister = allowRegister;
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
     * @return The actiTitle
     */
    public String getActiTitle() {
        return actiTitle;
    }

    /**
     * @param actiTitle The acti_title
     */
    public void setActiTitle(String actiTitle) {
        this.actiTitle = actiTitle;
    }

    /**
     * @return The allowToken
     */
    public Boolean getAllowToken() {
        return allowToken;
    }

    /**
     * @param allowToken The allow_token
     */
    public void setAllowToken(Boolean allowToken) {
        this.allowToken = allowToken;
    }

    /**
     * @return The registerMonth
     */
    public Boolean getRegisterMonth() {
        return registerMonth;
    }

    /**
     * @param registerMonth The register_month
     */
    public void setRegisterMonth(Boolean registerMonth) {
        this.registerMonth = registerMonth;
    }

    /**
     * @return The codeacti
     */
    public String getCodeacti() {
        return codeacti;
    }

    /**
     * @param codeacti The codeacti
     */
    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    /**
     * @return The moduleRegistered
     */
    public Boolean getModuleRegistered() {
        return moduleRegistered;
    }

    /**
     * @param moduleRegistered The module_registered
     */
    public void setModuleRegistered(Boolean moduleRegistered) {
        this.moduleRegistered = moduleRegistered;
    }

    /**
     * @return The codemodule
     */
    public String getCodemodule() {
        return codemodule;
    }

    /**
     * @param codemodule The codemodule
     */
    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    /**
     * @return The registerProf
     */
    public Boolean getRegisterProf() {
        return registerProf;
    }

    /**
     * @param registerProf The register_prof
     */
    public void setRegisterProf(Boolean registerProf) {
        this.registerProf = registerProf;
    }

    /**
     * @return The profInst
     */
    public Object getProfInst() {
        return profInst;
    }

    /**
     * @param profInst The prof_inst
     */
    public void setProfInst(Object profInst) {
        this.profInst = profInst;
    }

    /**
     * @return The registerStudent
     */
    public Boolean getRegisterStudent() {
        return registerStudent;
    }

    /**
     * @param registerStudent The register_student
     */
    public void setRegisterStudent(Boolean registerStudent) {
        this.registerStudent = registerStudent;
    }

    /**
     * @return The allowedPlanningStart
     */
    public String getAllowedPlanningStart() {
        return allowedPlanningStart;
    }

    /**
     * @param allowedPlanningStart The allowed_planning_start
     */
    public void setAllowedPlanningStart(String allowedPlanningStart) {
        this.allowedPlanningStart = allowedPlanningStart;
    }

    /**
     * @return The rdvIndivRegistered
     */
    public Object getRdvIndivRegistered() {
        return rdvIndivRegistered;
    }

    /**
     * @param rdvIndivRegistered The rdv_indiv_registered
     */
    public void setRdvIndivRegistered(Object rdvIndivRegistered) {
        this.rdvIndivRegistered = rdvIndivRegistered;
    }

    /**
     * @return The rdvGroupRegistered
     */
    public Object getRdvGroupRegistered() {
        return rdvGroupRegistered;
    }

    /**
     * @param rdvGroupRegistered The rdv_group_registered
     */
    public void setRdvGroupRegistered(Object rdvGroupRegistered) {
        this.rdvGroupRegistered = rdvGroupRegistered;
    }

    /**
     * @return The project
     */
    public Boolean getProject() {
        return project;
    }

    /**
     * @param project The project
     */
    public void setProject(Boolean project) {
        this.project = project;
    }

    /**
     * @return The moduleAvailable
     */
    public Boolean getModuleAvailable() {
        return moduleAvailable;
    }

    /**
     * @param moduleAvailable The module_available
     */
    public void setModuleAvailable(Boolean moduleAvailable) {
        this.moduleAvailable = moduleAvailable;
    }

    /**
     * @return The titlemodule
     */
    public String getTitlemodule() {
        return titlemodule;
    }

    /**
     * @param titlemodule The titlemodule
     */
    public void setTitlemodule(String titlemodule) {
        this.titlemodule = titlemodule;
    }

    /**
     * @return The typeTitle
     */
    public String getTypeTitle() {
        return typeTitle;
    }

    /**
     * @param typeTitle The type_title
     */
    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    /**
     * @return The typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * @param typeCode The type_code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * @return The nbGroup
     */
    public Integer getNbGroup() {
        return nbGroup;
    }

    /**
     * @param nbGroup The nb_group
     */
    public void setNbGroup(Integer nbGroup) {
        this.nbGroup = nbGroup;
    }

    /**
     * @return The numEvent
     */
    public Integer getNumEvent() {
        return numEvent;
    }

    /**
     * @param numEvent The num_event
     */
    public void setNumEvent(Integer numEvent) {
        this.numEvent = numEvent;
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
     * @return The room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room The room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return The allowedPlanningEnd
     */
    public String getAllowedPlanningEnd() {
        return allowedPlanningEnd;
    }

    /**
     * @param allowedPlanningEnd The allowed_planning_end
     */
    public void setAllowedPlanningEnd(String allowedPlanningEnd) {
        this.allowedPlanningEnd = allowedPlanningEnd;
    }

    /**
     * @return The scolaryear
     */
    public String getScolaryear() {
        return scolaryear;
    }

    /**
     * @param scolaryear The scolaryear
     */
    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    /**
     * @return The start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start The start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return The codeevent
     */
    public String getCodeevent() {
        return codeevent;
    }

    /**
     * @param codeevent The codeevent
     */
    public void setCodeevent(String codeevent) {
        this.codeevent = codeevent;
    }

    /**
     * @return The inMoreThanOneMonth
     */
    public Boolean getInMoreThanOneMonth() {
        return inMoreThanOneMonth;
    }

    /**
     * @param inMoreThanOneMonth The in_more_than_one_month
     */
    public void setInMoreThanOneMonth(Boolean inMoreThanOneMonth) {
        this.inMoreThanOneMonth = inMoreThanOneMonth;
    }

    /**
     * @return The nbHours
     */
    public String getNbHours() {
        return nbHours;
    }

    /**
     * @param nbHours The nb_hours
     */
    public void setNbHours(String nbHours) {
        this.nbHours = nbHours;
    }

    /**
     * @return The display
     */
    public String getDisplay() {
        return display;
    }

    /**
     * @param display The display
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * @return The dates
     */
    public Object getDates() {
        return dates;
    }

    /**
     * @param dates The dates
     */
    public void setDates(Object dates) {
        this.dates = dates;
    }

    /**
     * @return The nbMaxStudentsProjet
     */
    public Object getNbMaxStudentsProjet() {
        return nbMaxStudentsProjet;
    }

    /**
     * @param nbMaxStudentsProjet The nb_max_students_projet
     */
    public void setNbMaxStudentsProjet(Object nbMaxStudentsProjet) {
        this.nbMaxStudentsProjet = nbMaxStudentsProjet;
    }

    /**
     * @return The isRdv
     */
    public String getIsRdv() {
        return isRdv;
    }

    /**
     * @param isRdv The is_rdv
     */
    public void setIsRdv(String isRdv) {
        this.isRdv = isRdv;
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
     * @return The title
     */
    public Object getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(Object title) {
        this.title = title;
    }

    /**
     * @return The eventRegistered
     */
    public Boolean getEventRegistered() {
        return eventRegistered;
    }

    /**
     * @param eventRegistered The event_registered
     */
    public void setEventRegistered(Boolean eventRegistered) {
        this.eventRegistered = eventRegistered;
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
     * @return The past
     */
    public Boolean getPast() {
        return past;
    }

    /**
     * @param past The past
     */
    public void setPast(Boolean past) {
        this.past = past;
    }

    /**
     * @return The totalStudentsRegistered
     */
    public Integer getTotalStudentsRegistered() {
        return totalStudentsRegistered;
    }

    /**
     * @param totalStudentsRegistered The total_students_registered
     */
    public void setTotalStudentsRegistered(Integer totalStudentsRegistered) {
        this.totalStudentsRegistered = totalStudentsRegistered;
    }

}