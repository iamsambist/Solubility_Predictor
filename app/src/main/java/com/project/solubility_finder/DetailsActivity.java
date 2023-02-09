package com.project.solubility_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
TextView p,m,r,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Resources res=getResources();
        String details[]=res.getStringArray(R.array.Details);
        intializeViews();
        p.setText(details[0]);
        m.setText(details[1]);
        r.setText(details[2]);
        a.setText(details[3]);

    }

    private void intializeViews() {
        p=findViewById(R.id.phDetail);
        m=findViewById(R.id.moleculeDetail);
        r=findViewById(R.id.bonddetails);
        a=findViewById(R.id.acromaticDetails);
    }
}