package com.example.ritwikjain.app1;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements  AdapterView.OnItemClickListener {
    ListView listView;
    Communicator communicator;

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    String[] headings,bodies;
    int [] images={R.drawable.choco1,R.drawable.jelly,R.drawable.strawberry,R.drawable.vanilla,R.drawable.ic_launcher_background,R.drawable.choco1,R.drawable.jelly,R.drawable.strawberry,R.drawable.vanilla,R.drawable.ic_launcher_background};
     View v;
    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.v= inflater.inflate(R.layout.content_custom_list, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView=(ListView)v.findViewById(R.id.lv);
        Resources res= getResources();

        headings=res.getStringArray(R.array.headings);
        bodies=res.getStringArray(R.array.bodies);
        MyAdapter adapter=new MyAdapter(getActivity(),headings,images,bodies);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(communicator!=null)
            communicator.respond(i);

    }
    public interface Communicator
    {
        public void respond(int index);
    }
}

