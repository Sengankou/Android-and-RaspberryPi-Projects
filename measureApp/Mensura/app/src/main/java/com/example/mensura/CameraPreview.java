package com.example.mensura;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback{
    SurfaceHolder mSurfaceHolder;
    Camera mCamera;
    public CameraPreview(Context context) {
        super(context);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        try{
            int openCameraType = Camera.CameraInfo.CAMERA_FACING_BACK;
            if(openCameraType <= Camera.getNumberOfCameras()){
                mCamera = Camera.open(openCameraType);
                mCamera.setPreviewDisplay(holder);
            }
            else{
                Log.d("mensura", "cannot bind camera.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int width, int height){
        setPreViewSize(width, height);
        mCamera.startPreview();
    }

    private void setPreViewSize(int width, int height) {
    }

    protected void setPreviewSize(int width, int height){
        Camera.Parameters params = mCamera.getParameters();
        List<Camera.Size> supported = params.getSupportedPreviewSizes();
        if(supported != null){
            for(Camera.Size size:supported) {
                if(size.width <= width && size.height <= height){
                    params.setPreviewSize(size.width, size.height);
                    mCamera.setParameters(params);
                    break;
                }
            }
        }
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }
}
