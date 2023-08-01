package com.example.myelementary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Songs extends AppCompatActivity implements AdapterView.OnItemClickListener {
private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        ListView ls=findViewById(R.id.listview);
        String songs[]=new String[song.songs.length];
        for(int i=0;i<song.songs.length;i++)
        {
            songs[i]=song.songs[i].getName();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(player!=null)
        {
            player.stop();
            player.release();
        }
        int song_id=song.songs[position].getId();
        player=MediaPlayer.create(this,song_id);
        player.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}