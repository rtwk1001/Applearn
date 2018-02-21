package com.example.ritwikjain.app1;

import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentPagerActivity extends android.support.v4.app.FragmentActivity {
  ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        vp=(ViewPager)findViewById(R.id.viewpager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        vp.setAdapter(new MyPagerAdapter(fragmentManager));
    }
}
  class MyPagerAdapter extends FragmentStatePagerAdapter{
  Fragment fragment;
      public MyPagerAdapter(FragmentManager fm) {
          super(fm);
      }

      @Override
      public Fragment getItem(int position) {
          if(position==0)
              fragment=new FragmentA();
          if(position==1)
              fragment=new FragmentB();
          if(position==2)
              fragment=new FragmentC();
          return fragment;
      }

      @Override
      public int getCount() {
          return 3;
      }

      @Override
      public CharSequence getPageTitle(int position) {
          if(position==0)
              return "ListVIew ";
          if (position==1)
              return "Tab 2";
          if(position==2)
              return "Tab 3";
          return null;
      }
  }
