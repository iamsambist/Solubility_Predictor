package com.project.solubility_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button details,submit;
    private EditText ph,mw,rb,ar;
    TextView result;
    private String url="https://sambist.pythonanywhere.com/predict";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details=findViewById(R.id.details);
        submit=findViewById(R.id.submit);
        ph=findViewById(R.id.mph);
        mw=findViewById(R.id.mmw);
        rb=findViewById(R.id.mrb);
        ar=findViewById(R.id.map);
        result=findViewById(R.id.finalresult);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // code to hit the api
                boolean check=chekInputConstraint();
                if(check){
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // instruction when api hit the response

                                    try {
                                        JSONObject jsonObject=new JSONObject(response);
                                        String data=jsonObject.getString("logS");
                                        result.setText("log base 10 of Solubility of This Molecule is : "+data);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // when some error occours
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            result.setText(error.getMessage());
                        }
                    }){
                        // passing the values of input fields
                        @Override
                        protected Map<String,String> getParams(){
                            Map<String,String>params=new HashMap<>();
                            params.put("MolLogP",ph.getText().toString());
                            params.put("MolWt",mw.getText().toString());
                            params.put("NumRotatableBonds",rb.getText().toString());
                            params.put("AromaticProportion",ar.getText().toString());

                            return params;
                        }
                    };
                    RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                    queue.add(stringRequest);
                }
            }
        });
    }

    private boolean chekInputConstraint() {
        return true;
    }
}