package com.example.panda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Accout extends Fragment  {

    private  View view;
    private  TextView textname;


    public Accout() {
        // Required empty public constructor
    }

    public static Accout newInstance() {
        Accout fragment = new Accout();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] array = {"Ma QR","hai phong", "ha noi", "hcm","can tho"};

        view = inflater.inflate(R.layout.fragment_accout, container, false);

        textname = view.findViewById(R.id.txt_hoten);
        TextView textemail = view.findViewById(R.id.txt_email);
        TextView textphone = view.findViewById(R.id.txt_sdt) ;





        ImageView imageView = (ImageView) view.findViewById(R.id.imv_accout);
        final ListView listView = (ListView) view.findViewById(R.id.lv_accout1);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lin_accout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAttract();
            }
        });

        ArrayAdapter <String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, array);
              listView.setAdapter(listViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    switch (position){
                        case 0:
                            goToMaQR();
                            break;
                        case 1:

                        case 2:
                    }
                }
            });

        return view;
    }


    public void goToAttract()
    {
        Intent intent = new Intent(getActivity().getApplication(),SelelectAccout.class);
        startActivity(intent);

    }
    public void goToMaQR()
    {
        Intent intent = new Intent(getActivity().getApplication(),MaQR.class);
        startActivity(intent);
    }

}
