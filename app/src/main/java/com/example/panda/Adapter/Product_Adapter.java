package com.example.panda.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.panda.Models.Product;
import com.example.panda.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class Product_Adapter extends BaseAdapter {


    Context context;
    ArrayList<Product> arrayList;
    int layout;


    public Product_Adapter(Context context ,int layout ,ArrayList<Product> arrayList) {
    //    super(context, 0,arrayList);

        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView name, unit, price;
        ImageView photo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem_product,parent,false);

            holder.name = convertView.findViewById(R.id.name);
            holder.unit = convertView.findViewById(R.id.unit);
            holder.price = convertView.findViewById(R.id.price);
            holder.photo = convertView.findViewById(R.id.anh);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = arrayList.get(position);
        holder.name.setText("Tên:\t" + product.getName());
        holder.unit.setText("ĐơnVị:\t" + product.getUnit());
        holder.price.setText(String.valueOf("Giá:\t" + product.getPrice() + "\tVND"));
        Picasso.get().load(product.getUrlhinh()).into(holder.photo);




        return convertView;
    }
}
