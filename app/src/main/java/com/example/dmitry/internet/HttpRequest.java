package com.example.dmitry.internet;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dmitry.internet.ParamsBuilder;
import com.example.dmitry.listener.GetObjectListener;
import com.example.dmitry.test.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class HttpRequest extends AsyncTask<ParamsBuilder, Void, Object> {

    public static final int TIME_OUT = 25 * 1000;
    private GetObjectListener mListener;

    private boolean mIsExecuting;

    public HttpRequest(GetObjectListener listener) {
        mListener = listener;
    }

    public boolean isExecuting() {
        return mIsExecuting;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mIsExecuting = true;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Logger.d(this, "IS CANCEL!");
        mIsExecuting = false;
    }

    @Override
    protected Object doInBackground(ParamsBuilder... params) {
        HttpClient httpClient;
        HttpGet httpGet;
        HttpPost httpPost;
        HttpResponse httpResponse;
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
        HttpConnectionParams.setSoTimeout(httpParameters, TIME_OUT);
        httpClient = new DefaultHttpClient(httpParameters);
        if (!params[0].isPost()) {
            try {
                Log.d("fail", params[0].getUrl());
                httpGet = new HttpGet(params[0].getUrl());
                try {
                    httpResponse = httpClient.execute(httpGet);
                } catch (IOException e) {
                    return null;
                }
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            Log.d("fail", params[0].postUrl());
            httpPost = new HttpPost(params[0].postUrl());
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            Map<String, String> postParams = params[0].getParams();
            Set<Map.Entry<String, String>> set = postParams.entrySet();
            for (Map.Entry<String, String> entry : set) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs));
                httpResponse = httpClient.execute(httpPost);
            } catch (IOException e) {
                return null;
            }
        }
        if (httpResponse != null) {
            Log.d("help", "isConnect");
            HttpEntity httpEntity = httpResponse.getEntity();
            try {
                if (httpEntity != null) {
                    String parseString = EntityUtils.toString(httpEntity, "UTF-8");
                    Logger.d(this, parseString + "");
                    Parser parser = new Parser();
                    return parser.parse(parseString, params[0]);
                } else {
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object parseObject) {
        Logger.d(this, "STOP!");
        mListener.onGetObject(parseObject);
        mIsExecuting = false;
    }
}
