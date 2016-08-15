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

//    private List<Journals> parseJournals(String parseString) {
//        Gson gson = new Gson();
//        try {
//            JSONObject jsonObject = new JSONObject(parseString);
//            List<Journals> journalsList = new ArrayList<>();
//            if (jsonObject.getInt("total") == 0) {
//                return journalsList;
//            }
//            JSONArray jsonArray = jsonObject.getJSONArray("journals");
//            for (int i = 0; i < jsonArray.length(); i++) {
//                Journals journals = gson.fromJson(jsonArray.get(i).toString(), Journals.class);
//                journals.setEditedon(journals.getEditedon() * 1000);
//                journals.setUnpubDate(journals.getUnpubDate() * 1000);
//                journalsList.add(journals);
//            }
//            return journalsList;
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private List<Books> parseBooks(String parseString) {
//        Gson gson = new Gson();
//        try {
//            JSONObject jsonObject = new JSONObject(parseString);
//            List<Books> booksList = new ArrayList<>();
//            if (jsonObject.getInt("total") == 0) {
//                return booksList;
//            }
//            JSONArray jsonArray = jsonObject.getJSONArray("books");
//            for (int i = 0; i < jsonArray.length(); i++) {
//                Books books = gson.fromJson(jsonArray.get(i).toString(), Books.class);
//                books.setEditedon(books.getEditedon() * 1000);
//                books.setUnpubDate(books.getUnpubDate() * 1000);
//                booksList.add(books);
//            }
//            return booksList;
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    private Users parseUser(String parseString) {
//        Gson gson = new Gson();
//        return gson.fromJson(parseString, Users.class);
//    }
}
