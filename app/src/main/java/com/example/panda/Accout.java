package com.example.panda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.panda.Adapter.Accout_Adapter;
import com.example.panda.Database_SQL.DatabaseSQL;
import com.example.panda.Models.Accout_Information;
import com.example.panda.Models.SelelectAccout;

import java.util.List;


public class Accout extends Fragment   {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Bitmap bm;
    private  View view;

    private  TextView textname;
    private  TextView textemail;
    private  TextView textphone;
    private  ImageView imageView;
    private ImageButton imageButton;

    private ListView lvaccout, listView;

    private List<Accout_Information> arrayList;
    private Accout_Adapter accout_adapter;
    private DatabaseSQL databaseSQL;

    private Cursor cursor;

    public  Accout() {
    }

    public static Accout newInstance(String param1, String param2, int phone) {
        Accout fragment = new Accout();
        Bundle args = new Bundle();
        args.putString("name", param1);
        args.putString("email", param2);
        args.putInt("phone",phone);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString("name");
//            mParam2 = getArguments().getString("email");
//            phone = getArguments().getInt("phone", phone);
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] array = { "hai phong", "ha noi", "hcm", "can tho"};

        view = inflater.inflate(R.layout.fragment_accout, container, false);

        textname = view.findViewById(R.id.txt_name);
        textemail = view.findViewById(R.id.txt_email);
        textphone = view.findViewById(R.id.txt_phone);
        imageView = view.findViewById(R.id.img_photo);
        lvaccout = view.findViewById(R.id.lv_accout);
        imageButton = view.findViewById(R.id.btn_edit);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAccout();
            }
        });

        databaseSQL = new DatabaseSQL(getActivity());
        //tao data cho bang
   //     databaseSQL.QueryData("INSERT INTO Accout VALUES (null, 'tran hoai vi', 'vi@gmail.com', '123456')");
        Cursor cursor = databaseSQL.GetData(" SELECT * FROM Accout ");
        while (cursor.moveToNext()) {

            textname.setText(cursor.getString(1));
            textemail.setText(cursor.getString(2));
            textphone.setText(cursor.getString(3));

        }

//        arrayList = databaseSQL.getAllAccout();
//        setAdapter();
//        updateListAccout();



        listView =  view.findViewById(R.id.lv_accout1);
        ArrayAdapter <String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, array);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        break;
                    case 1:

                    case 2:
                }
            }
        });
            return view;
}

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void goToSelectAccout()
    {
        Intent intent = new Intent(getActivity(), SelelectAccout.class);
        startActivity(intent);
    }



}
