package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class splashActivity extends AppCompatActivity {
Animation top,bottom;
    ImageView header,footer,icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        top= AnimationUtils.loadAnimation(splashActivity.this,R.anim.top_anim);
        bottom= AnimationUtils.loadAnimation(splashActivity.this,R.anim.bottom_anim);

        header=findViewById(R.id.header_splash);
        footer=findViewById(R.id.footer_splash);
        icon=findViewById(R.id.photo_splash);
        header.setAnimation(top);
        icon.setAnimation(top);
        footer.setAnimation(bottom);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent=new Intent(splashActivity.this,MainActivity.class);
        startActivity(intent);
        Animatoo.animateFade(splashActivity.this);
        finish();
    }
},3000);





    }

}