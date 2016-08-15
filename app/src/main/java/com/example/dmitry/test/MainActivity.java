package com.example.dmitry.test;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dmitry.internet.ApiManager;
import com.example.dmitry.listener.GetWayTrackListener;
import com.example.dmitry.models.WayTrack;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.PathOverlay;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        String hash = "58ecdea2a91f32aa4c9a1d2ea010adcf2348166a04";
        String avKey = "1M1TE9oeWTDK6gFME9JYWXqpAGc%3D";
        int trackId = 36131;
        int userId = 22;
        final IMapController mapController = map.getController();
        mapController.setZoom(9);
        ApiManager.getINSTANCE().getWayTrack(new GetWayTrackListener() {
            @Override
            public void onGetTrack(WayTrack track) {
                Float[][] points = track.getPoints();
                TypedArray ta = getResources().obtainTypedArray(R.array.color_walk);
                int[] colors = new int[ta.length()];
                for (int i = 0; i < ta.length(); i++) {
                    colors[i] = ta.getColor(i, 0);
                }
                ta.recycle();
                GeoPoint start = new GeoPoint(points[0][0], points[0][1]);
                mapController.setCenter(start);
                mapController.setZoom(15);
                int count = 0;
                for (int i = 0; i < points.length; i++) {
                    count = getCount(points[i][5]);
                    Polyline polyline = new Polyline(getApplicationContext());
                    List<GeoPoint> pointList = new ArrayList<GeoPoint>();
                    polyline.setColor(colors[count]);
                    GeoPoint point = new GeoPoint(points[i][0], points[i][1]);
                    pointList.add(point);
                    while (i + 1 < points.length && getCount(points[i+1][5]) == count) {
                        i++;
                        GeoPoint nextPoint = new GeoPoint(points[i][0], points[i][1]);
                        pointList.add(nextPoint);
                    }
                    if (i + 1 < points.length) {
                        GeoPoint lastPoint = new GeoPoint(points[i + 1][0], points[i+1][1]);
                        pointList.add(lastPoint);
                    }
                    polyline.setPoints(pointList);
                    map.getOverlayManager().add(polyline);
                }
            }
        }, hash, avKey, trackId, userId);
    }

    private int getCount(float velocity) {
        if (velocity >= 0 && velocity < 5) {
            return 0;
        } else if (velocity >= 5 && velocity < 10) {
            return 1;
        } else if (velocity >= 10 && velocity < 15) {
            return 2;
        } else {
            return 3;
        }
    }
}
