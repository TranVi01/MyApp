package com.example.panda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
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


public class Accout extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  View view;

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
        String[]array1 = {"da nang", "hue", "khanh hoa"};
        String[] array = {"Ma QR","hai phong", "ha noi", "hcm","can tho"};

        view = inflater.inflate(R.layout.fragment_accout, container, false);

        TextView textname = (TextView)view.findViewById(R.id.txt_hoten);
        TextView textemail = (TextView)view.findViewById(R.id.txt_email);
        TextView textphone = (TextView)view.findViewById(R.id.txt_sdt) ;

        SelelectAccout selelectAccout = (SelelectAccout) getActivity();
        String datafromActivity = selelectAccout.getData();





//        bd.getString("name",textname.toString());
//        bd.getString("email",textemail.toString());
//        bd.getString("phone",textphone.toString());


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
//
//        ArrayAdapter <String> listViewAdapter1 = new ArrayAdapter<String>(
//                getActivity(), android.R.layout.simple_list_item_1, array1);
//        listView1.setAdapter(listViewAdapter1);

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




    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//
//    public interface OnFragmentManager() {
//        void onDataSelected(String ) // ở đây các bạn truyền dữ liệu cần chuyển qua Fragment kia nhé
//    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentManager) {
//            mListener = (OnFragmentManager) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
