package playlistIterator.observer;

import playlistIterator.Song;

public interface PlaylistObserver {
    void onPlayListChanged(Song song, String action);
}
