package playlistIterator;

public class Song {
    private final String songName;
    private final String artistName;

    public Song(String name, String artistName) {
        this.songName = name;
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }
    @Override
    public String toString(){
        return "song name: " + this.songName + "; artist name: " + artistName;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof Song)) return true;
        Song other = (Song) obj;
        return other.songName.equals(this.songName) && other.artistName.equals(this.artistName);
    }
}
