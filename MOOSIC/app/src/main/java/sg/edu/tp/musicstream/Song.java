package sg.edu.tp.musicstream;

public class Song
{
    private String id;
    private String title;
    private String artist;
    private String fileLink;
    private double songLength;
    private String coverArt;

    //constructor
    public Song(String i, String t, String a, String f, double sl, String ca)
    {
        id = i;
        title = t;
        artist = a;
        fileLink= f;
        songLength = sl;
        coverArt = ca;
    }
    //method getId
    public String getId()
    {
        return id;
    }

    //method setId
    public void setId(String newId)
    {
        id = newId;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getFileLink()
    {
        return fileLink;
    }

    public String getCoverArt()
    {
        return coverArt;
    }
}
