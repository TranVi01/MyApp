package com.example.panda;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.panda.Adapter.Product_Adapter;
import com.example.panda.Models.Product;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class Home extends Fragment {

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Home () {
    }

    private static final String TAG = "";
    private View v;
    private ListView listView;
    Product_Adapter product_adapter;
    private ArrayList<Product> productList;
    DatabaseReference databaseReference;
    private ProgressDialog progressDialog;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home, container, false);

        listView = v.findViewById(R.id.lv_product);
        Progressdialog();
        progressDialog.show();
        productList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("data_product");
        product_adapter = new Product_Adapter(getActivity(),android.R.layout.simple_list_item_1 ,productList);
        listView.setAdapter(product_adapter);

        // show data from firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Product product = ds.getValue(Product.class);
                    productList.add(product);

                }
                product_adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Dialogproduct(position);

            }
        });


        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void Progressdialog (){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(" Please wait...");
        progressDialog.setMax(50);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

    }
    public void Dialogproduct (int position){
        Product product = productList.get(position);
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(product.getName() + "\n" + "\tgiá:" + product.getPrice()+ "VNĐ");
        dialog.setMessage("Do you want to add the cart?");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"added to the cart!", Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();

    }
}
