package com.example.dmitry.internet;

import com.example.dmitry.models.WayTrack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Parser {

    public Object parse(String parseString, ParamsBuilder paramsBuilder) {
        switch (paramsBuilder.getEnumParse()) {
            case WAY_TRACK:
                return parseWayTrack(parseString);
            default:
                return null;
        }
    }

    private WayTrack parseWayTrack(String parseString) {
        Gson gson = new Gson();
        return gson.fromJson(parseString, WayTrack.class);
    }
}
