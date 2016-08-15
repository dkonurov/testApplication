package com.example.dmitry.models;


import com.google.gson.annotations.SerializedName;

public class WayTrack {

    @SerializedName("aTrack")
    private Track track;

    @SerializedName("sMsg")
    private String msg;

    @SerializedName("sMsgTitle")
    private String msgTitle;

    @SerializedName("bStateError")
    private Boolean stateError;

    @SerializedName("min_id")
    private Integer minId;

    @SerializedName("aPoints")
    private Float[][] points;


    public void setTrack(Track track) {
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public Boolean getStateError() {
        return stateError;
    }

    public void setStateError(Boolean stateError) {
        this.stateError = stateError;
    }

    public Integer getMinId() {
        return minId;
    }

    public void setMinId(Integer minId) {
        this.minId = minId;
    }


    public Float[][] getPoints() {
        return points;
    }

    public void setPoints(Float[][] points) {
        this.points = points;
    }
}
