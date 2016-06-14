package com.example.user.gofish;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by davidmor on 26/03/2016.
 */
public class GamePanel extends SurfaceView
        implements SurfaceHolder.Callback{

    public MainThread thread;
    public boolean Pause_game;
    GameActivity game;
    private Bitmap backgroundBitmap;

    public GamePanel(Context context, GameActivity game,int ScreenWidth,int Screenheigt) {
        super(context);
        getHolder().addCallback(this);
        this.game = game;
        thread = new MainThread(getHolder(), this);
        backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gamebg);
        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap,ScreenWidth, Screenheigt, false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){

        }
        if (event.getAction()==MotionEvent.ACTION_UP){

        }

        return true;
    }

    void Draw(Canvas canvas){
        if (!Pause_game)
            if (canvas!=null){
                canvas.drawColor(Color.BLACK);
                canvas.drawBitmap(backgroundBitmap, 0, 0, null);
            }
    }

    void Update(float dt){


    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }
}
