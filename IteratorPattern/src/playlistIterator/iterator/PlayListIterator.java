package playlistIterator.iterator;

import playlistIterator.Playlist;
import playlistIterator.Song;

public class PlayListIterator implements SongIterator {
    private final Playlist playlist;
    int index = 0;

    public PlayListIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index<playlist.size();
    }

    @Override
    public Song moveNext() {
        return playlist.getSongAt(index++);
    }
    @Override
    public void reset(){
        index=0;
    }
}
