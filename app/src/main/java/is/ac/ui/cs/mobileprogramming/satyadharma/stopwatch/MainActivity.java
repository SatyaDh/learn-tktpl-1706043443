package is.ac.ui.cs.mobileprogramming.satyadharma.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

import java.util.Locale;


public class MainActivity extends Activity {

    private  int seconds = 0 ;
    private  boolean running;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            doubleBackToExitPressedOnce = savedInstanceState.getBoolean("doubleBackToExitPressedOnce");

        }
        runTimer();
    }
    public  void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }


    public void onClickStart(View v)
    {
        running = true;

    }
    public void onClickStop(View v)
    {
        running = false;
    }
    public void onClickReset(View v)
    {
        running = false;
        seconds = 0 ;
    }


    private void runTimer()

    {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final android.os.Handler handler = new android.os.Handler();
        handler.post(new Runnable() {
            @Override
            public void run()
            {
                int hours = (seconds/3600) ;
                int minutes = (seconds%3600)/60 ;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


}