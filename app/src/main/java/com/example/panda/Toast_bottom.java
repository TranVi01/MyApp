package com.example.panda;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressLint("RestrictedApi")
public class Toast_bottom extends BottomSheetDialogFragment  {

    private static final int RESULT_OK = 1;
    private BottomSheetListener mListener;
    int REQUEST_CODE =  111;
    private static final int PICK_IMAGE = 222;
    private ImageView imageView1;


    public static Toast_bottom newtoast_bottom(){
        Toast_bottom fragment = new Toast_bottom();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.toast_bottom, container, false);

        Button button_camera = v.findViewById(R.id.btn_camera);
        Button button_library = v.findViewById(R.id.btn_library);
        imageView1 = v.findViewById(R.id.img_accout2);


        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE);
                dismiss();
            }
        });


        button_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent,getString(R.string.supervisor_profile_choose_image_title));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, PICK_IMAGE);
                dismiss();
            }
        });
        return v;
    }



    // luu anh tam thoi trong thu muc
//    private Uri saveToInternalStorage(Bitmap bitmapImage) {
//        ContextWrapper cw = new ContextWrapper(getApplicationContext());
//        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
//        File myPath = new File(directory, "your_image_name");
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(myPath);
//            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                fos.close();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return Uri.fromFile(myPath);
//    }

//    private Context getApplicationContext() {
//
//    }

 //xu ly ket qua tra ve

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            try {
                Uri imageUri = data.getData();
                Bitmap photo = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(),  imageUri);

            } catch (IOException e) {

            }

            return;    }
    }



    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }
}
