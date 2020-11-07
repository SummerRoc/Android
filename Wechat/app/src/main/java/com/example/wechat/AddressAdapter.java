package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AddressAdapter extends ArrayAdapter<Address> {
    private  int resourceId;

    public AddressAdapter(Context context, int textViewResourceId, List<Address> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Address addressList = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView addressImage = (ImageView) view.findViewById(R.id.image);
        TextView addressName =(TextView) view.findViewById(R.id.name);

        addressImage.setImageResource(addressList.getImageId());
        addressName.setText(addressList.getPreSent());
        return view;
    }
}
