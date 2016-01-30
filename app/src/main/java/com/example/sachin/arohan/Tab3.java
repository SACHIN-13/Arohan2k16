package com.example.sachin.arohan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab3 extends Fragment {
    ListView list;
    String[] web = {
            "EVENT1",
            "EVENT2",
            "EVENT3",
            "EVENT4",
            "EVENT5",
            "EVENT6",
            "EVENT7"
    } ;
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7

    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_3,container,false);
        CustomList adapter = new
                CustomList(v.getContext()getContext(), web, imageId);
        list=(ListView)v.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(v.getContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return v;

    }
}