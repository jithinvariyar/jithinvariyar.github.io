package com.jithin;

import com.jithin.model.Artist;
import com.jithin.model.DataSource;
import com.jithin.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Can not open the connection");
            return;
        }
        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_DESC);
        if(artists != null){
            for(Artist artist : artists){
                System.out.println("ID= " + artist.getId() + " : NAME= " + artist.getName());
            }
            System.out.println("*************************************************");
        } else {
            System.out.println("No Artists");
            System.out.println("*************************************************");
            return;
        }

        List<String> albums = dataSource.queryAlbumsForArtist("Carole king",DataSource.ORDER_BY_ASC);
        if(albums != null){
            for(String album : albums){
                System.out.println(album);
            }
            System.out.println("*************************************************");
        }else {
            System.out.println("No albums");
            System.out.println("*************************************************");
            return;
        }

        List<SongArtist> songArtists = dataSource.queryArtistForSong("she's on fire",DataSource.ORDER_BY_ASC);
        if(songArtists != null){
            for(SongArtist songArtist : songArtists){
                System.out.println("Artist : " + songArtist.getArtistName() + "\t" + "Album: " + songArtist.getAlbumName() + "\t" + "Track: " + songArtist.getTrack());
            }
            System.out.println("*************************************************");
        } else {
            System.out.println("There is no such song");
            System.out.println("*************************************************");
            return;
        }
        dataSource.createViewForSongArtists();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the song title: ");
        String title = scanner.nextLine();
        songArtists = dataSource.querySongInfoView(title);
        if (songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist artist : songArtists){
            System.out.println("FROM VIEW -- Artist name = " + artist.getArtistName() +
                                " Album name = " + artist.getAlbumName() +
                                " Track Number = " + artist.getTrack());
        }
        dataSource.insertSong("Touch Of Grey","Grateful Dead","In The Dark",1);
        dataSource.close();
    }
}
