package com.example.laundrydokan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.laundrydokan.Prevalent.Sessions;


public class SplashActivity extends AppCompatActivity {
    Animation topAnimation, bottomAnimation;
    LottieAnimationView animationView;
    ImageView imageView;
    Button joinbutton,loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animationView = findViewById(R.id.animationView);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.toptodown);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.downtotop);
        imageView = findViewById(R.id.image);
        joinbutton = findViewById(R.id.joinbutton);
        loginbutton = findViewById(R.id.loginbutton);
        imageView.setAnimation(bottomAnimation);
        joinbutton.setAnimation(bottomAnimation);
        loginbutton.setAnimation(bottomAnimation);
        animationView.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                animationView.playAnimation();

            }
        },2000);


        if(Sessions.getLoginStatusofUser(SplashActivity.this))
        {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if(Sessions.getLoginStatusofAdmin(SplashActivity.this)){
           Intent intent = new Intent(SplashActivity.this, AdminCatagoryActivity.class);
            startActivity(intent);
            finish();
        }

        joinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(SplashActivity.this,SignupActivity.class);
                SplashActivity.this.startActivity(mainIntent);
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);

            }
        });


    }
}