package playlistIterator;

import playlistIterator.iterator.PlayListIterator;
import playlistIterator.iterator.PlayListIteratorByArtist;
import playlistIterator.iterator.SongIterator;
import playlistIterator.observer.PlaylistObserver;

import java.util.*;

public class Playlist {
    private List<Song> songs = new ArrayList<>();
    private List<PlaylistObserver> observers = new ArrayList<>();

    public SongIterator createIterator(){
        return new PlayListIterator(this);
    }
    public SongIterator createIteratorByArtist(String artist){
        return new PlayListIteratorByArtist(artist, this);
    }
    public void addSong(Song song){
        this.songs.add(song);
        this.notifyObservers(song, "ADD");
    }
    public void deleteSong(int idx){
        Song song = songs.get(idx);
        songs.remove(idx);
        this.notifyObservers(song, "DELETE");
    }
    public int size(){
        return songs.size();
    }
    public Song getSongAt(int i){
        if(i<0 || i>= songs.size()) return null;
        return songs.get(i);
    }
    public void addObserver(PlaylistObserver observer){
        this.observers.add(observer);
    }
    public boolean removeObserver(PlaylistObserver observer){
        return this.observers.remove(observer);
    }
    private void notifyObservers(Song song, String action){
        for(PlaylistObserver obv : observers){
            obv.onPlayListChanged(song, action);
        }
    }


}
