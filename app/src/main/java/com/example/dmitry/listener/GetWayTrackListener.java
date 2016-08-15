package com.example.dmitry.listener;


import com.example.dmitry.models.WayTrack;

public abstract class GetWayTrackListener implements GetObjectListener {
    @Override
    public void onGetObject(Object object) {
        onGetTrack((WayTrack) object);
    }

    abstract public void onGetTrack(WayTrack track);
}
