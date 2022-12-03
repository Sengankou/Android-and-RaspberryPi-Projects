package com.example.rasp_camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview implements SurfaceHolder.Callback {
    SurfaceHolder mSurfaceHolder;

    public CameraPreview(Context context, SurfaceView sv){
        mSurfaceHolder = sv.getHolder();
        mSurfaceHolder.addCallback(this);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        Log.d("MyApp", "surfaceCreated");
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.RED);
        canvas.drawCircle(100, 200, 50, paint);
        holder.unlockCanvasAndPost(canvas);
        Rect clip = new Rect(0, 0, 640, 320);
        canvas.save();
        canvas.clipRect(clip);
        canvas.restore();
//          RaspCameraHttpGetTask task = new RaspCameraHttpGetTask(context);
//          task.execute();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int width, int height){
        Log.d("MyApp", "surfaceChanged");
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        Log.d("MyApp", "surfaceDestroyed");
    }
}
