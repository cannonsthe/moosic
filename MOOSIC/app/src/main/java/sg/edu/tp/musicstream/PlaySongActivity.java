package sg.edu.tp.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import sg.edu.tp.musicstream.util.AppUtil;

public class PlaySongActivity extends AppCompatActivity
{

    //declare the base URL for the music
    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";
    //declare other variables
    private String songId = "";
    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private String coverArt = "";
    private String url = "";
    private String nextArt = "";

    Boolean shuffleFlag = false;

    //declare the MusicPlayer object
    private MediaPlayer player = null;
    SeekBar seekBar;
    private Handler handler = new Handler();

    //declare a variable to store music position
    private int musicPosition = 0;

    //declare the button variable
    private ImageButton btnPlayPause = null;
    private ImageButton btnLoop;
    private ImageButton btnShuffle;

    //create a SongCollection object
    SongCollection songCollection = new SongCollection();
    SongCollection originalsongCollection = new SongCollection();

    List<Song> shuffleList = Arrays.asList(songCollection.songs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        //retrieve the PlayPause Button
        btnPlayPause = (ImageButton) findViewById(R.id.btnPlayPause);
        btnLoop = (ImageButton) findViewById(R.id.btnLoop);
        btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);


        retrieveData();

        displaySong(title, artist, coverArt);

        //scrubable seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBar);{
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                {
                    if(fromUser)
                        player.seekTo(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    player.seekTo(seekBar.getProgress());
                }
            });
        }

    }

    //prevent overlapping of audio
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player != null){
            handler.removeCallbacks(bar);
            player.stop();
            player.release();
            player = null;

        }
    }

    //method retrieveData
    public void retrieveData()
    {
        Bundle songData = this.getIntent().getExtras();

        songId = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");

        url = BASE_URL + fileLink;
    }

    public void displaySong(String title, String artist, String coverArt)
    {
        //find the Song Title TextView from the screen
        TextView txtTitle = (TextView)findViewById(R.id.txtSongTitle);
        //set the text of the TextView to the selected song title
        txtTitle.setText(title);

        TextView txtArtist = (TextView)findViewById(R.id.txtArtist);
        txtArtist.setText(artist);

        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);
        ImageView ivCoverArt = (ImageView) findViewById(R.id.imgCoverArt);
        ivCoverArt.setImageResource(imageId);

    }
    private void preparePlayer()
    {
        player = new MediaPlayer(); //create a mediaplayer object

        try
        {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url); //indicate the url of the song to the player
            player.prepare();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    //action when music ends, oncompletionlistener
    private void WhenMusicEnds()
    {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mediaPlayer)
            {
                autoPlay();

            }
        });
    }

    Runnable bar = new Runnable() {
        @Override
        public void run() {
            if (player!=null && player.isPlaying()){
                seekBar.setProgress(player.getCurrentPosition());
            }
            handler.postDelayed(this,50);
        }
    };

    public void playOrPauseMusic(View view)
    {
        if (player == null) //first time invoke the player object
            preparePlayer();

        if (!player.isPlaying())
        {
            if (musicPosition > 0)
            {
                player.seekTo(musicPosition);
            }

            player.start();
            seekBar.setMax(player.getDuration());
            handler.postDelayed(bar, 50);
            btnPlayPause.setImageResource(R.drawable.ic_action_pause);
            setTitle("Now Playing: " + title + " - " + artist);
            WhenMusicEnds();
        }
        else
        {
            pauseMusic();
            handler.removeCallbacks(bar);
        }
    }

    //prepare the player to autoplay next song
    public void Autoplay()
    {
        if (player == null) //first time invoke the player object
            preparePlayer();

        else
            stopActivities();preparePlayer();


        if (!player.isPlaying())
        {
            if (musicPosition > 0)
            {
                player.seekTo(musicPosition);
            }

            player.start();
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(bar);
            handler.postDelayed(bar, 50);
            btnPlayPause.setImageResource(R.drawable.ic_action_pause);
            setTitle("Now Playing: " + title + " - " + artist);
            WhenMusicEnds();
        }
        else
        {
            pauseMusic();
        }
    }

    //loop music
    boolean toggleLoop = true;

    public void loopMusic(View view)
    {
        if(toggleLoop){
            player.setLooping(toggleLoop);
            toggleLoop = !toggleLoop;
            AppUtil.popMessage(this, "Looping current song");

        }else if(!toggleLoop){
            player.setLooping(false);
            AppUtil.popMessage(this,  "Looping turned off");
            toggleLoop = true;
        }
    }

    public void shuffleSong (View view)
    {
        if (shuffleFlag)
        {
            AppUtil.popMessage(this,"Shuffling stopped");
            songCollection = new SongCollection();
        }
        else
        {
            AppUtil.popMessage(this,"Shuffling playlist...");
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
        }
        shuffleFlag = !shuffleFlag;
    }




    private void pauseMusic()
    {
        player.pause();

        musicPosition = player.getCurrentPosition();

        btnPlayPause.setImageResource(R.drawable.ic_action_name);
    }

    public void stopActivities()
    {
        if(player != null)
        {
            //btnPlayPause.setText("PLAY");
            musicPosition = 0;
            setTitle(" ");
            player.stop();
            player.release();
            player = null;
        }
    }

    //getting next song details for autoplay
    public void autoPlay()
    {
        Song autoplay = songCollection.getNextSong(songId);
        if (autoplay != null)
        {
            songId = autoplay.getId();
            title = autoplay.getTitle();
            artist = autoplay.getArtist();
            fileLink = autoplay.getFileLink();
            coverArt = autoplay.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);
            stopActivities();
            Autoplay();
        }
    }



    //method playnext
    public void playNext(View view)
    {
        Song nextSong = songCollection.getNextSong(songId);
        if (nextSong != null)
        {
            songId = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFileLink();
            coverArt = nextSong.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);
            stopActivities();
            playOrPauseMusic(view);
        }
    }

    //method playprev
    public void playPrevious (View view)
    {
        Song previoussong = songCollection.getPrevSong(songId);
        if (previoussong != null)
        {
            songId = previoussong.getId();
            title = previoussong.getTitle();
            artist = previoussong.getArtist();
            fileLink = previoussong.getFileLink();
            coverArt = previoussong.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);
            stopActivities();
            playOrPauseMusic(view);
        }
    }
}
