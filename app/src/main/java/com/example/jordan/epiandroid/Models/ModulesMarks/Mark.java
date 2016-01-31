package com.example.jordan.epiandroid.Models.ModulesMarks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mark {
    private String scolaryear;
    private String codemodule;
    private String titlemodule;
    private String codeinstance;
    private String codeacti;
    private String title;
    private String date;
    private String correcteur;

    @JsonProperty("final_note")
    private String finalNote;
    private String comment;

    public String getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getCodemodule() {
        return codemodule;
    }

    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    public String getTitlemodule() {
        return titlemodule;
    }

    public void setTitlemodule(String titlemodule) {
        this.titlemodule = titlemodule;
    }

    public String getCodeinstance() {
        return codeinstance;
    }

    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    public String getCodeacti() {
        return codeacti;
    }

    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCorrecteur() {
        return correcteur;
    }

    public void setCorrecteur(String correcteur) {
        this.correcteur = correcteur;
    }

    public String getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(String finalNote) {
        this.finalNote = finalNote;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
