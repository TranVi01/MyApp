package com.example.panda.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.panda.Models.Accout_Information;
import com.example.panda.R;
import java.util.List;


public class Accout_Adapter implements Adapter {
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


//    private Context context;
//    private int layout;
//    private List<Accout_Information> accoutList;
//
//    public Accout_Adapter(Context context, int resource, Context context1) {
//        super(context, 0,resource);
//        this.context = context1;
//    }
//
//    public Accout_Adapter(Context context, int layout, List<Accout_Information> accoutList) {
//        super(context, layout,accoutList);
//        this.context = context;
//        this.layout = layout;
//        this.accoutList = accoutList;
//    }
//
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    private class ViewHolder {
//        TextView txtname, txtemail, txtphone;
//        ImageView imgimg;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        holder = new ViewHolder();
//
//        if (convertView == null ){
//             holder = new ViewHolder();
////            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            convertView = inflater.inflate(R.layout.listitem_accout, null);
//
//            holder.txtname = (TextView) convertView.findViewById(R.id.txt_name);
//            holder.txtemail = convertView.findViewById(R.id.txt_email);
//            holder.txtphone = convertView.findViewById(R.id.txt_phone);
////            holder.imgimg = convertView.findViewById(R.id.img_photo);
//            convertView.setTag(holder);
//        }else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        Accout_Information accout_information = accoutList.get(position);
//        holder.txtname.setText(accout_information.getName());
//        holder.txtemail.setText(accout_information.getEmail());
//        holder.txtphone.setText(accout_information.getPhone());
//
////        byte[] photo = accout_information.getImage();
////        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
////        holder.imgimg.setImageBitmap(bitmap);
//
//
//        return convertView;
//    }

}
