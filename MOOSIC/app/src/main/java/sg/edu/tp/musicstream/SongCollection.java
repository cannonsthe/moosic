package sg.edu.tp.musicstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongCollection
{
    //creates arraylist for song objects
    public Song [] songs = new Song [27];

    //constructor
    public SongCollection()
    {
        prepareSongs();
    }

    //method prepareSongs
    private void prepareSongs()
    {
        //create song object called thewayyoulooktonight
        Song Betternow = new Song("P01",
                "Better Now",
                "Blanks",
                "30727cca3dbefa4c3a962daf46ce0b9e5a3c6639?cid=2afe87a64b0042dabf51f37318616965",
                2.93,
                "better_now");

        //create song object called billiejean
        Song Bittersweet = new Song ( "P02",
                "Bittersweet",
                "Blanks",
                "f0610f25281749a766afc594540d61545de86d95?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                "bittersweet");

        //create song object called dancealone
        Song Castleofglass = new Song ("P03",
                "CASTLE OF GLASS",
                "Linkin Park",
                "48fcbc7609d8fcfcd10ebd3d262ef36d8cbfa07c?cid=2afe87a64b0042dabf51f37318616965",
                3.42,
                "castle_of_glass");

        Song Coolkids = new Song("P04",
                "Cool Kids",
                "Echosmith",
                "27df0a89036135748fd03fb67114abeb00c529a4?cid=2afe87a64b0042dabf51f37318616965",
                3.96,
                "cool_kids");

        Song Dontstop = new Song("P05",
                "Don't stop",
                "Blanks",
                "fd0feeec7be4a2220c0404e93bdbf0f7c68e1617?cid=2afe87a64b0042dabf51f37318616965",
                3.02,
                "dont_stop");

        Song Foreveryoung = new Song("P06",
                "Forever Young",
                "Alphaville",
                "847a8d10c771089bbb767c1763f4b54b76115442?cid=2afe87a64b0042dabf51f37318616965",
                3.78,
                "forever_young");

        Song Heavy = new Song("P07",
                "Heavy (feat. Kiiara)",
                "Linkin Park",
                "54f76a271f9d9995eafc92cab90e1f7e021ebc14?cid=2afe87a64b0042dabf51f37318616965",
                2.83,
                "heav");

        Song Higher = new Song("P08",
                "Higher",
                "Blanks",
                "502babff18086cee183b82d249bae64720cd230d?cid=2afe87a64b0042dabf51f37318616965",
                3.17,
                "high");

        Song Hope = new Song("P09",
                "Hope",
                "The Chainsmokers",
                "746135186e339c276d9f00f310286ce210782347?cid=2afe87a64b0042dabf51f37318616965",
                3,
                "hop");

        Song Iridescent = new Song("P10",
                "Iridescent",
                "Linkin Park",
                "cb5b84cf816a2aadc4161ce9dabaa258b25fd095?cid=2afe87a64b0042dabf51f37318616965",
                4.94,
                "irides");

        Song Letsgetlost = new Song("P11",
                "Let's Get Lost",
                "Blanks",
                "ec3117604f0365e2434d45e3b95378299ee39f1a?cid=2afe87a64b0042dabf51f37318616965",
                2.92,
                "lets_get_lost");

        Song Levelofconcern = new Song("P12",
                "Level of Concern",
                "Twenty One Pilots",
                "07c282084563ef61b97b04a0f82b4e7235c8b6ee?cid=2afe87a64b0042dabf51f37318616965",
                3.67,
                "level_of_concern");

        Song Lonelygeneration = new Song("P13",
                "Lonely Generation",
                "Echosmith",
                "e3a8eec7836902d4173805a2968f2b9ad9133fa6?cid=2afe87a64b0042dabf51f37318616965",
                3.43,
                "lonely_generation");

        Song Onmymind = new Song("P14",
                "On My Mind",
                "Diplo, SIDEPIECE",
                "e685b6f1e597a642eda805509a2b6c7359bda73b?cid=2afe87a64b0042dabf51f37318616965",
                3.15,
                "on_my_mind");

        Song Onemorelight = new Song("P15",
                "One More Light",
                "Linkin Park",
                "7ea4eef2ed25e30cd90bbef3dc5ef3503ac1afeb?cid=2afe87a64b0042dabf51f37318616965",
                4.25,
                "one_more_light");

        Song Overmyhead = new Song("P16",
                "Over My Head",
                "Echosmith",
                "121d8e0b05f0941a0c3a507f25408c08fc8c42a9?cid=2afe87a64b0042dabf51f37318616965",
                3.47,
                "over_my_head");

        Song Paris = new Song("P17",
                "Paris",
                "The Chainsmokers",
                "2524797ca9b06a157f21199be68f0f0e94f71661?cid=2afe87a64b0042dabf51f37318616965",
                3.69,
                "pari");

        Song Sickboy = new Song("P18",
                "Sick Boy",
                "The Chainsmokers",
                "a2e3e0b89d2623af24f3b69780dcd0ed75fb816c?cid=2afe87a64b0042dabf51f37318616965",
                3.22,
                "sick_boy");

        Song Seaside = new Song("P19",
                "Seaside",
                "Blanks",
                "1226e31d0d8ea8406acd342d56ea2d147681c10d?cid=2afe87a64b0042dabf51f37318616965",
                3.81,
                "silly_people");

        Song Somekindofmagic = new Song("P20",
                "Some Kind Of Magic",
                "LVTHER, Myzica",
                "302da1177772c48117c1acc84b404325aacff2b2?cid=2afe87a64b0042dabf51f37318616965",
                3.24,
                "some_kind_of_magic");

        Song Somethingjustlikethis = new Song("P21",
                "Something Just Like This",
                "The Chainsmokers",
                "cb1ae1f9e2f874dd2d19e4c29edb552777eb1e7a?cid=2afe87a64b0042dabf51f37318616965",
                4.12,
                "something_just_like_this");

        Song Stressedout = new Song("P22",
                "Stressed Out",
                "Twenty One Pilots",
                "0e0951b811f06fea9162eb7e95e4bae4802d97af?cid=2afe87a64b0042dabf51f37318616965",
                3.37,
                "stressed_out");

        Song Sweaters = new Song("P23",
                "Sweaters",
                "Blanks",
                "aff62b2d56c54aa39b217364898f5c07ef77ce7b?cid=2afe87a64b0042dabf51f37318616965",
                2.96,
                "sweaters");

        Song Thislove = new Song("P24",
                "This Love",
                "LVTHER, Savoi",
                "ac0683d4dfa5f133f8ce4eca31ed3ed04c7c8528?cid=2afe87a64b0042dabf51f37318616965",
                3.02,
                "this_love");

        Song Wave = new Song("P25",
                "Wave",
                "Blanks",
                "30dd56fdb07a1a2a55d07f0cd2efc36da3c535b9?cid=2afe87a64b0042dabf51f37318616965",
                2.59,
                "wave");



        //store song objects into array
        songs[0] = Betternow;
        songs[1] = Bittersweet;
        songs[2] = Castleofglass;
        songs[3] = Coolkids;
        songs[4] = Dontstop;
        songs[5] = Foreveryoung;
        songs[6] = Heavy;
        songs[7] = Higher;
        songs[8] = Hope;
        songs[9] = Iridescent;
        songs[10] = Letsgetlost;
        songs[11] = Levelofconcern;
        songs[12] = Lonelygeneration;
        songs[13] = Onmymind;
        songs[14] = Onemorelight;
        songs[15] = Overmyhead;
        songs[16] = Paris;
        songs[17] = Sickboy;
        songs[18] = Seaside;
        songs[19] =  Somekindofmagic;
        songs[20] = Somethingjustlikethis;
        songs[21] = Stressedout;
        songs[22] = Sweaters;
        songs[23] = Thislove;
        songs[24] = Wave;
    }

    //method searchById
    public Song searchById (String id)
    {
        //Create Song object, null means empty object
        Song s = null;

        //search
        for (int i = 0; i < songs.length; i++)
        {
            //take out the current song object
            s = songs[i];
            if (s.getId().equals(id)) //if current song id is the same as search song id
            {
                return s;
            }
        }
        return null;
    }

    //method getnextsong
    public Song getNextSong (String currentSongId)
    {
        Song song = null;

        //traverse the array
        for(int index = 0; index < songs.length; index++)
        {
            if (songs[index].getId().equals(currentSongId) && (index < songs.length -1))
            {
                song = songs[index+1]; //get the next song and store it into "song" object
                break; //break out of for loop
            }
        }
        return song;
    }

    //method getprevsong
    public Song getPrevSong (String currentSongId)
    {
        Song song = null;

        //traverse the array
        for (int index = 0; index < songs.length; index++)
        {
            if (songs[index].getId().equals(currentSongId) && (index < songs.length -1))
            {
                song = songs[index-1];
                break;
            }
        }
        return song;
    }
}
