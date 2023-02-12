package sg.edu.tp.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;

import sg.edu.tp.musicstream.util.AppUtil;

public class MainActivity extends AppCompatActivity
{
    private SongCollection songCollection = new SongCollection();
    static ArrayList<Song> favList = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //method handleSelection
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
        Intent Playlist = new Intent(this, Main3Activity.class);
        startActivity(Playlist);
    }


    public void addToFavourite(View view) {

        String songID = view.getContentDescription().toString();
        Song song = songCollection.searchById(songID);
        favList.add(song);
        //Toast.makeText(this, "harharhR", Toast.LENGTH_SHORT).show();
    }
}