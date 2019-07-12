package com.example.panda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class QR extends Fragment {

    public static QR newQR(){
        QR fragment = new QR();
        return fragment;
    }
    Button button;
    TextView txt_name;
    ImageView imghinh;
    View view;
    private IntentIntegrator intentIntegrator;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.qr, container, false);

        button = view.findViewById(R.id.btn_maqr);
        imghinh = view.findViewById(R.id.img_qr);
        txt_name = view.findViewById(R.id.txt_qr);

        intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        intentIntegrator.setPrompt("Scan QR code");
        intentIntegrator.setCameraId(0);
        // bao tieng beep khi quet thanh cong
        intentIntegrator.setBeepEnabled(true);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentIntegrator.initiateScan();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                txt_name.setText(result.getContents());

//               Picasso.get().load(result.getContents()).into(imghinh);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
