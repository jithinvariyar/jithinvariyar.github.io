package learnjava;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    //private ArrayList<Song> songs;
    private SongList songs;

    public Album(String name , String artist) {
        this.name = name;
        this.artist = artist;
        //this.songs = new ArrayList<Song>();
        this.songs = new SongList();
    }

    public boolean addSong(String title , double duration){
        return this.songs.addSong(new Song(title,duration));
//        if(findSong(title) == null){
//            this.songs.add(new Song(title , duration));
//            return true;
//        }
//        return false;
    }

//    private Song findSong(String title){
//        for(Song checkedSong : this.songs) {
//            if(checkedSong.getTitle().equals(title)){
//                return checkedSong;
//            }
//        }
//        return null;
//    }

    public boolean addToPlayList(int trackNumber , LinkedList<Song> playList){
//        int index = trackNumber - 1;
//        if(index >= 0 && index <= this.songs.size()){
//            playList.add(this.songs.get(index));
//            return true;
//        }
        if(songs.findSong(trackNumber-1)!= null){
            playList.add(songs.findSong(trackNumber));
            return true;
        }
        System.out.println("This album does not have a track : " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title , LinkedList<Song> playlist){
        Song checkSong = songs.findSong(title);
        if(checkSong != null){
            playlist.add(checkSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album " + this.name);
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean addSong(Song song){
            if(songs.contains(song)){
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song checkedSong : this.songs) {
                if(checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if(index >=0 && index < songs.size()){
                return songs.get(index);
            }
            return null;
        }


    }





}
