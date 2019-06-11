package com.example.panda;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import java.io.IOException;


public class SelelectAccout extends AppCompatActivity {


    private   ImageView imageView;
    private EditText edtname, edtemail, edtsdt;

    int REQUEST_CODE =  111;
    private static final int PICK_IMAGE = 222;

    ActionBar actionBar;
    private static String name;
    private String email;
    private int sdt;
    private ImageView image;


    public SelelectAccout(){
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selelect_accout);

        imageView = findViewById(R.id.img_accout2);
        edtname = findViewById(R.id.edt_name);
        edtemail =  findViewById(R.id.edt_email);
        edtsdt =  findViewById(R.id.edt_phone);

        name = edtname.getText().toString();
        email = edtemail.getText().toString();

        Button btn_camre = (Button)findViewById(R.id.btn_camera);
        Button btn_library = (Button)findViewById(R.id.btn_library);

        btn_camre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        btn_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent,getString(R.string.supervisor_profile_choose_image_title));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, PICK_IMAGE);

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            try {
                Uri imageUri = data.getData();
                Bitmap photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(),  imageUri);
                imageView.setImageBitmap(photo);

            } catch (IOException e) {

            }

            return;    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Drawable drawable= getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getMenuInflater().inflate(R.menu.top_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.mn_save:
                InformationAccout informationAccout = new InformationAccout();
                informationAccout.setName(edtname.getText().toString());
                informationAccout.setEmail(edtemail.getText().toString());

//                Intent intent = new Intent(SelelectAccout.this, MainActivity.class);
//                intent.putExtra("name", edtname.getText().toString());
//                intent.putExtra("email", edtemail.getText().toString());
//                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }


}
