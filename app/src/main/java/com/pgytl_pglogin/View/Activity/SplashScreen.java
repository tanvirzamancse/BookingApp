package com.pgytl_pglogin.View.Activity;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pgytl_pglogin.R;
public class SplashScreen extends AppCompatActivity {
    private ImageView imageView;
    int progress;
    private ProgressBar progressBar;
    private static final int SPLASH_TIME_OUT = 4000;
    private TextView mr1,mr2;
    private Animation frombutton,fromTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView=findViewById(R.id.image);
        progressBar=findViewById(R.id.pro);
        mr1=findViewById(R.id.marquee1);
        mr2=findViewById(R.id.marquee2);

        mr1.setSelected(true);

        frombutton= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromTop= AnimationUtils.loadAnimation(this,R.anim.from_upper);
        mr1.setAnimation(frombutton);
        mr2.setAnimation(fromTop);


        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {
                GoTO();
                finish();
            }
        },SPLASH_TIME_OUT);

        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                doWork();
            }
        });

        thread.start();
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.10f);
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim.start();

        ObjectAnimator scaleAnim1 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.10f);
        scaleAnim1.setDuration(1000);
        scaleAnim1.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim1.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim1.start();

        ObjectAnimator mr = ObjectAnimator.ofFloat(mr1, "scaleY", 1.0f, 1.10f);
        mr.setDuration(1000);
        mr.setRepeatCount(ValueAnimator.INFINITE);
        mr.setRepeatMode(ValueAnimator.REVERSE);
        mr.start();
    }

    private void doWork() {
        for (progress=20;progress<=100;progress=progress+20){
            try {
                Thread.sleep(SPLASH_TIME_OUT);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void GoTO() {
        Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}