package com.example.dmitry.internet;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParamsBuilder {

    private Map<String, String> mParams;
    private static final String DEFAULT_URL = "http://avionicus.com/android/";

    private String mMethod;
    private EnumParse mEnumParse;

    public ParamsBuilder() {
        mParams = new HashMap<String, String>();
    }

    public void addParams(String name, String value) {
        if (value != null && name != null) {
            mParams.put(name, value);
        }
    }

    public void setEnumParse(EnumParse enumParse) {
        mEnumParse = enumParse;
    }

    public EnumParse getEnumParse() {
        return mEnumParse;
    }

    public boolean mIsPost;

    public String getUrl() throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder(DEFAULT_URL);
        builder.append(mMethod);
        if (mParams.size() != 0) {
            builder.append("?");
            Iterator<Map.Entry<String, String>> iterator = mParams.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                builder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                builder.append("=");
                builder.append(entry.getValue());
//                builder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (iterator.hasNext()) {
                    builder.append("&");
                }
            }
        }
        return builder.toString();
    }

    public String postUrl() {
        StringBuilder builder = new StringBuilder(DEFAULT_URL);
        builder.append(mMethod);
        return builder.toString();
    }

    public void setMethod(String method) {
        mMethod = method;
    }

    public void setIsPost(boolean isPost) {
        mIsPost = isPost;
    }

    public boolean isPost() {
        return mIsPost;
    }

    public Map<String, String> getParams() {
        return mParams;
    }
}
