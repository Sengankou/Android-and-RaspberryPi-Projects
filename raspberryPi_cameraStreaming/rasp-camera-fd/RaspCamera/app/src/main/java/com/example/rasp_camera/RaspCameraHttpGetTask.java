package com.example.rasp_camera;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RaspCameraHttpGetTask extends AsyncTask<Integer, Void, Void> {
    private Activity parentActivity;
    private final String uri = "http://192.168.11.18:5000/video_feed/";

    public RaspCameraHttpGetTask(Activity parentActivity){
        this.parentActivity = parentActivity;
    }

    //タスク開始時
    @Override
    protected  void onPreExecute(){
    }
    //メイン処理
    @Override
    protected Void doInBackground(Integer...arg0){
        Log.d("Access", uri);
        exec_get();
        return null;
    }
    //タスク終了時
    @Override
    protected void onPostExecute(Void result){

    }

    private String exec_get(){
        HttpURLConnection http = null;
        InputStream in = null;
        String src = new String();
        Bitmap image;
        try {
            //URLにHTTP接続
            URL url = new URL(uri);
            //connectionのインスタンス
            http = (HttpURLConnection) url.openConnection();
            //リクエストメソッドの指定
            http.setRequestMethod("GET");
            //通信開始
            http.connect();

            int responseCode = http.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //通信成功したので画像取得
                //データを取得
                in = http.getInputStream();
                //HTMLソースを読みだす
                byte[] line = new byte[1024];
                int size;
                while (true) {
                    size = in.read(line);
                    if (size <= 0) break;
                    src += new String(line);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(http != null) http.disconnect();
                if(in != null) in.close();
            }catch(Exception e){
            }
        }
        return src;
    }
}
