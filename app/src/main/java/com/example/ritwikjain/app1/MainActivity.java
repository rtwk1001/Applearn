package com.example.ritwikjain.app1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1 ,b2,listopen,fragmentpageropen;
    LinearLayout lay1;
    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.tv1);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        fragmentpageropen=(Button)findViewById(R.id.swipe);
        listopen=findViewById(R.id.list);
        lay1=(LinearLayout)findViewById(R.id.lay1);
        sb=(SeekBar)findViewById(R.id.sb);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                t1.setTextSize( i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                t1.setText("Hello hella!!");
                lay1.setBackgroundColor(R.color.mycolor);
            }



        });
        listopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(inten);
            }
        });
      fragmentpageropen.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this,FragmentPagerActivity.class);
              startActivity(intent);
          }
      });

    }
     public void mapOpen(View view){
        Intent intent,chooser;
         intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:19.076,72.877"));
        chooser=Intent.createChooser(intent,"Launch Map");
        startActivity(chooser);

     }

}
