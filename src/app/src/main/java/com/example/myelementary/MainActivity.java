package com.example.myelementary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // vars
    private Button game_b;
    private Button maths_b;
    private Button songs_b;

    // oncreate
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add listner
        game_b = (Button) findViewById(R.id.game_b);
        maths_b = (Button) findViewById(R.id.maths_b);
        songs_b = (Button) findViewById(R.id.song_b);
        game_b.setOnClickListener(this);
        maths_b.setOnClickListener(this);
        songs_b.setOnClickListener(this);
    } //

    // onclick listner
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.game_b:
                intent = new Intent(getApplicationContext(), Game.class);
                startActivity(intent);
                break;
            case R.id.maths_b:
                intent = new Intent(getApplicationContext(), Maths.class);
                startActivity(intent);
                break;
            case R.id.song_b:
                intent = new Intent(getApplicationContext(), Songs.class);
                startActivity(intent);
                break;
        }
    }//

    // on inflate option
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    } //

    // onoption item selected
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.about_item:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;
            case R.id.contact_item:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://github.com/fobybus/my-elementary"));
                startActivity(intent1);
                break;
            case R.id.exit_item:
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}