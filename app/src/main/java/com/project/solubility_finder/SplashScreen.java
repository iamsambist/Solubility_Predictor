package com.project.solubility_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView campusName,campusAdd,submitText,sunilBist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        intializeViews();

        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        int uiOptions= View.SYSTEM_UI_FLAG_FULLSCREEN;
        View decoderView=getWindow().getDecorView();
        decoderView.setSystemUiVisibility(uiOptions);
        hideAllOut();

        campusName.animate().translationYBy(6000).setDuration(1000);
        campusAdd.animate().translationYBy(6000).setDuration(1000);
        submitText.animate().translationYBy(6000).setDuration(1000);
        sunilBist.animate().translationYBy(6000).setDuration(1000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },3000);
    }

    private void hideAllOut() {
        campusName.setTranslationY(-6000);
        campusAdd.setTranslationY(-6000);
        submitText.setTranslationY(-6000);
        sunilBist.setTranslationY(-6000);
    }

    private void intializeViews() {
        campusName=findViewById(R.id.campusname);
        campusAdd=findViewById(R.id.campusadd);
        submitText=findViewById(R.id.submitby);
        sunilBist=findViewById(R.id.myname);
    }
}