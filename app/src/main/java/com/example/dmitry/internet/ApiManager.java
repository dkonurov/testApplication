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

//    public void authorize(GetUsersListener listener, String username, String password,
//                          String androidId) {
//        if (mGetRequest != null && mGetRequest.isExecuting()) {
//            return;
//        }
//        ParamsBuilder paramsBuilder = new ParamsBuilder();
//        paramsBuilder.setMethod(USERS_METHOD);
//        paramsBuilder.setEnumParse(EnumParse.USERS);
//        paramsBuilder.addParams("username", username);
//        paramsBuilder.addParams("device_id", androidId);
//        Utils utils = new Utils();
//        String correctPassword = utils.getMD5(password);
//        Logger.d(this, String.format("%s%s", correctPassword, SALT));
//        correctPassword = utils.getMD5(String.format("%s%s", correctPassword, SALT));
//        paramsBuilder.addParams("passwd", correctPassword);
//        mGetRequest = new HttpRequest(listener);
//        mGetRequest.execute(paramsBuilder);
//    }
//
//    public void getBooks(GetBooksListener listener, Integer page, String search) {
//        if (mGetRequest != null && mGetRequest.isExecuting()) {
//            return;
//        }
//        ParamsBuilder paramsBuilder = new ParamsBuilder();
//        paramsBuilder.setMethod(BOOKS_METHOD);
//        paramsBuilder.setEnumParse(EnumParse.BOOKS);
//        if (page != null) {
//            paramsBuilder.addParams("page", String.valueOf(page));
//        }
//        if (search != null) {
//            paramsBuilder.addParams("s", search);
//        }
//        mGetRequest = new HttpRequest(listener);
//        mGetRequest.execute(paramsBuilder);
//    }
//
//    public void getJournals(GetJournalsListener listener, Integer page, String search) {
//        if (mGetRequest != null && mGetRequest.isExecuting()) {
//            return;
//        }
//        ParamsBuilder paramsBuilder = new ParamsBuilder();
//        paramsBuilder.setMethod(JOURNALS_METHOD);
//        paramsBuilder.setEnumParse(EnumParse.JOURNALS);
//        if (page != null) {
//            paramsBuilder.addParams("page", String.valueOf(page));
//        }
//        if (search != null) {
//            paramsBuilder.addParams("s", search);
//        }
//        mGetRequest = new HttpRequest(listener);
//        mGetRequest.execute(paramsBuilder);
//    }
//
//    public void cancelRequest() {
//        if (mGetRequest != null && mGetRequest.isExecuting()) {
//            mGetRequest.cancel(true);
//        }
//    }
}
