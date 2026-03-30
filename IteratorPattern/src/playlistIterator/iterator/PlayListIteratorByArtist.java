package playlistIterator.iterator;

import playlistIterator.Playlist;
import playlistIterator.Song;
import playlistIterator.observer.PlaylistObserver;
import java.util.*;

import java.util.ArrayList;

public class PlayListIteratorByArtist implements SongIterator, PlaylistObserver {
    private List<Song> songsByArtist = new ArrayList<>();
    private final String artist;
    private int index=0;

    public PlayListIteratorByArtist(String artist, Playlist p) {
        this.artist = artist;
        SongIterator iterator = p.createIterator();
        while(iterator.hasNext()){
            Song song = iterator.moveNext();
            if(song.getArtistName().equals(artist)){
                songsByArtist.add(song);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < songsByArtist.size();
    }

    @Override
    public Song moveNext() {
        return songsByArtist.get(index++);
    }

    @Override
    public void onPlayListChanged(Song song, String action) {
        if(action.equals("ADD")){
            if(artist.equals(song.getArtistName())){
                songsByArtist.add(song);
            }
        }
        else if(action.equals("DELETE")){
            if(artist.equals(song.getArtistName())){
                songsByArtist.remove(song);
                if(index>songsByArtist.size()){
                    index = songsByArtist.size();
                }
            }
        }
    }
    @Override
    public void reset(){
        index=0;
    }
}
