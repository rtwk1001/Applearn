package com.example.ritwikjain.app1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomList extends AppCompatActivity {
    ListView listView;
    String[] headings,bodies;
int [] images={R.drawable.choco1,R.drawable.jelly,R.drawable.strawberry,R.drawable.vanilla,R.drawable.ic_launcher_background,R.drawable.choco1,R.drawable.jelly,R.drawable.strawberry,R.drawable.vanilla,R.drawable.ic_launcher_background};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_custom_list);
        listView=(ListView)findViewById(R.id.lv);
        Resources res= getResources();
        headings=res.getStringArray(R.array.headings);
        bodies=res.getStringArray(R.array.bodies);
    MyAdapter adapter=new MyAdapter(this,headings,images,bodies);
    listView.setAdapter(adapter);
    }

}
class MyViewHolder{
    ImageView myImage;
    TextView myHead;
    TextView myBody;
     MyViewHolder(View v){
         myImage=(ImageView)v.findViewById(R.id.image);
         myHead=(TextView)v.findViewById(R.id.heading);
         myBody=(TextView)v.findViewById(R.id.des);
     }
}
class MyAdapter extends ArrayAdapter<String>{
  Context context;
  int[]  images;
  String[] titles,description;
    public MyAdapter(@NonNull Context context,String[] titles,int[] imgs,String[] des) {
        super(context,R.layout.listitem,R.id.heading,titles);
        this.context=context;
        this.images=imgs;
        this.titles=titles;
        this.description=des;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row= convertView;
        MyViewHolder holder=null;
        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row = inflater.inflate(R.layout.listitem, parent, false);
             holder= new MyViewHolder(row);
             row.setTag(holder);
            Log.d("rtwk", "Creating new view");
        }
        else{
            holder=(MyViewHolder) row.getTag();
            Log.d("rtwk", "Recycling the view");
        }

        holder.myImage.setImageResource(images[position]);
        holder.myHead.setText(titles[position]);
        holder.myBody.setText(description[position]);
        return row;
    }
}