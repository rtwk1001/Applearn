package com.example.ritwikjain.app1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FragmentActivity extends AppCompatActivity implements FragmentA.Communicator {
 FragmentA fragmentA;
 FragmentB fragmentB;
 FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        manager=getFragmentManager();
       /* fragmentA= new FragmentA();
        fragmentB= new FragmentB();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.grp,fragmentA,"fa");

        transaction.add(R.id.grp,fragmentB,"fb");
        transaction.commit();
       *//*FragmentA frag=(FragmentA)manager.findFragmentByTag("fa");
        frag.setCommunicator(this);*//*
       respond(3);*/
    }

    @Override
    public void respond(int index) {

     //  fragmentB=(FragmentB)manager.findFragmentByTag("fb");
       if(fragmentB!=null && fragmentB.isVisible()){
           fragmentB.setText(index);
       }

    }
}
