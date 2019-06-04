package com.example.panda;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MaQR extends AppCompatActivity {

    Button button;
    TextView txt_name, txt_diachi;
    ImageView imghinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_qr);

        button = (Button)findViewById(R.id.btn_maqr);
        txt_name = (TextView)findViewById(R.id.txt_nameqr);
        txt_diachi = (TextView)findViewById(R.id.txt_diachi);
        imghinh = (ImageView)findViewById(R.id.img_qr);

        final IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentIntegrator.initiateScan();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Picasso.get().load(result.getContents()).into(imghinh);
                try {
                    JSONObject jsonObject = new JSONObject(result.getContents());
                    txt_diachi.setText(jsonObject.getString("DiaChi"));
                    txt_name.setText(jsonObject.getString("Name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Drawable drawable= getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        getMenuInflater().inflate(R.menu.top_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
