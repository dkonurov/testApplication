package com.example.dmitry.internet;

import com.example.dmitry.listener.GetWayTrackListener;

public class ApiManager {

    private static final String TRACK = "track_v0649.php";
    private static ApiManager INSTANCE;
    private HttpRequest mGetRequest;

    private ApiManager() {

    }

    public static ApiManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ApiManager();
        }

        return INSTANCE;
    }

    public void getWayTrack(GetWayTrackListener listener, String hash, String avKey, Integer trackId, Integer userId) {
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.setMethod(TRACK);
        paramsBuilder.addParams("hash", hash);
        paramsBuilder.addParams("avkey", avKey);
        paramsBuilder.addParams("track_id", String.valueOf(trackId));
        paramsBuilder.addParams("user_id", String.valueOf(userId));
        paramsBuilder.setEnumParse(EnumParse.WAY_TRACK);
        mGetRequest = new HttpRequest(listener);
        mGetRequest.execute(paramsBuilder);
    }
}
