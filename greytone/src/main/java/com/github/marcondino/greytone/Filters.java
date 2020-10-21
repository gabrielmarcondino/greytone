package com.github.marcondino.greytone;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class Filters {

    public Filters() {
        if (OpenCVLoader.initDebug()) {
            Log.d("OpenCV","OpenCV is Configured and Running Successfully.");
        } else {
            Log.d("OpenCV","OpenCV is not Working.");
        }
    }

    public Bitmap grayFilter(Bitmap bitmap){
        Mat tmp = new Mat (bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC1);
        Utils.bitmapToMat(bitmap, tmp);
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);
        Utils.matToBitmap(tmp, bitmap);
        return bitmap;
    }
}

