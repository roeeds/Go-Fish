package com.example.user.gofish;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity {
    final static int UPDATE_SCORE = 0;
    final static int DEATH = 1;
    final static int LOSE = 2;

    MediaPlayer MainMusic;
    RelativeLayout Rel_main_game;
    GamePanel game_panel;
    int score=0;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==UPDATE_SCORE){


            }
            if (msg.what==DEATH){
                postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Message msg = handler.obtainMessage();
                        msg.what = LOSE;
                        handler.sendMessage(msg);

                    }
                }, 3000);
            }
            if (msg.what==LOSE){

            }

            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        /*
        // Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
ActionBar actionBar = getActionBar();
actionBar.hide();
        */

        Rel_main_game = (RelativeLayout) findViewById(R.id.game_rl);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        final int heightS = dm.heightPixels;
        final int widthS = dm.widthPixels;
        game_panel = new GamePanel(getApplicationContext(), this,widthS, heightS);
        Rel_main_game.addView(game_panel);

    }

    @Override
    protected void onStart() {
        super.onStart();
        MainMusic = MediaPlayer.create(GameActivity.this, R.raw.gamesong);
        MainMusic.setVolume(0.3f, 0.3f);
        MainMusic.start();
    }

    @Override
    protected void onPause() {
        if (MainMusic.isPlaying()) {
            MainMusic.stop();
            MainMusic.release();
        }
        super.onPause();
        //Log.d("LIFE_CYCLE", "onPause");
    }
    @Override
    public void onBackPressed() {

        game_panel.Pause_game=true;
        game_panel.thread.setRunning(false);
        super.onBackPressed();
        GameActivity.this.finish();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }
}
