package com.example.dmitry.models;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Track {

    @SerializedName("type")
    private String type;

    @SerializedName("dt_start")
    private String dateStart;

    @SerializedName("dt_end")
    private String dateEnd;

    @SerializedName("time")
    private Long time;

    @SerializedName("distance")
    private Float distance;

    @SerializedName("id_track")
    private Long trackId;

    @SerializedName("sp_avg")
    private Float spAvg;

    @SerializedName("sp_max")
    private Float spMax;

    @SerializedName("calories")
    private Float calories;

    @SerializedName("description")
    private String description;

    @SerializedName("access")
    private Integer access;

    @SerializedName("weight")
    private Integer weight;

    @SerializedName("cardio")
    private Integer cardio;

    @SerializedName("hr_max")
    private Integer hrMax;

    @SerializedName("hr_avg")
    private Integer hrAvg;

    @SerializedName("var_max")
    private Integer varMax;

    @SerializedName("var_min")
    private Integer varMin;

    @SerializedName("status")
    private Boolean status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Float getSpAvg() {
        return spAvg;
    }

    public void setSpAvg(Float spAvg) {
        this.spAvg = spAvg;
    }

    public Float getSpMax() {
        return spMax;
    }

    public void setSpMax(Float spMax) {
        this.spMax = spMax;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCardio() {
        return cardio;
    }

    public void setCardio(Integer cardio) {
        this.cardio = cardio;
    }

    public Integer getHrMax() {
        return hrMax;
    }

    public void setHrMax(Integer hrMax) {
        this.hrMax = hrMax;
    }

    public Integer getHrAvg() {
        return hrAvg;
    }

    public void setHrAvg(Integer hrAvg) {
        this.hrAvg = hrAvg;
    }

    public Integer getVarMax() {
        return varMax;
    }

    public void setVarMax(Integer varMax) {
        this.varMax = varMax;
    }

    public Integer getVarMin() {
        return varMin;
    }

    public void setVarMin(Integer varMin) {
        this.varMin = varMin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
