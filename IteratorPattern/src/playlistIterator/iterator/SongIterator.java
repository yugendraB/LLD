package playlistIterator.iterator;

import playlistIterator.Song;

public interface SongIterator {
    boolean hasNext();
    Song moveNext();
    void reset();
}
