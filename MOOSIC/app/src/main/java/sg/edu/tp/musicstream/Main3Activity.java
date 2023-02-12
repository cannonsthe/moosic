package sg.edu.tp.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sg.edu.tp.musicstream.util.AppUtil;

public class Main3Activity extends AppCompatActivity {
RecyclerView favList;
SongAdapter songAdapter;
    private SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        favList = findViewById(R.id.recyclerView);

        songAdapter = new SongAdapter(MainActivity.favList);
        favList.setAdapter(songAdapter);
        favList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void goHome (View view)
    {
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
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

    public void removeAll(View view) {
        MainActivity.favList.clear();
        songAdapter.notifyDataSetChanged();
    }


    public void handleSelection(View view)
    {

        //1. Get id of the selected song
        String resourceId = AppUtil.getResourceId(this, view);

        //2.search for the selected song based on the id
        Song selectedSong = songCollection.searchById(resourceId);

        //popup messageo on the screen to show the title of the selected song
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

        //4. Send the song data to the player screen to be played
        sendDataToActivity (selectedSong);

    }


    //method sendDataToActivity
    public void sendDataToActivity (Song song)
    {
        Intent intent = new Intent(this, PlaySongActivity.class);

        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artist", song.getArtist());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());

        startActivity(intent);
    }
}
