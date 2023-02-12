package sg.edu.tp.musicstream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }
    public void goHome (View view)
    {
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
        finish();
    }

    public void goSearch (View view)
    {
        Intent Search = new Intent(this, SearchActivity.class);
        startActivity(Search);
        finish();
    }

    public void goPlaylist (View view)
    {
        Intent Playlist  = new Intent(this, Main3Activity.class);
        startActivity(Playlist);
        finish();
    }




}
