package com.example.ritwikjain.app1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment{
     TextView tv;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_b, container, false);
        tv=(TextView)v.findViewById(R.id.fr2txt);

        return v;
    }

    public void setText(int index){
        String[] des=getResources().getStringArray(R.array.bodies);
        tv.setText(des[index]);
    }

}
