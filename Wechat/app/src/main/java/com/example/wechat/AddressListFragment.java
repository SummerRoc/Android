package com.example.wechat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class AddressListFragment extends Fragment {


    private List<Address> addressList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_address_list, container, false);
        initAdress();
        AddressAdapter adapter = new AddressAdapter(getActivity(),R.layout.activity_list_item,addressList);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return view;
    }

    private  void initAdress(){
        Address xiaoming = new Address(R.drawable.touxiang,"小明");
        addressList.add(xiaoming);
        Address xiaohong = new Address(R.drawable.touxiang,"小红");
        addressList.add(xiaohong);
        Address xiaohuang = new Address(R.drawable.touxiang,"小黄");
        addressList.add(xiaohuang);
    }
}