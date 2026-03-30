package playlistIterator;

import playlistIterator.iterator.PlayListIterator;
import playlistIterator.iterator.PlayListIteratorByArtist;
import playlistIterator.iterator.SongIterator;
import playlistIterator.observer.PlaylistObserver;

public class MusicPlayer {

    public static void print(SongIterator iterator){
        iterator.reset();
        while(iterator.hasNext()){
            Song song = iterator.moveNext();
            System.out.println(song.toString());
            System.out.println("-----------------------------------------");
        }
    }
    public static void main(String[] args) {
        Playlist p1 = new Playlist();
        p1.addSong(new Song("Idemitamma maya", "rajashekar"));
        p1.addSong(new Song("chinnaga chinnaga", "chiranjeevi"));
        p1.addSong(new Song("sanchari", "shruti"));
        SongIterator iterator = p1.createIterator();
        SongIterator iteratorByArtist = p1.createIteratorByArtist("shruti");
        p1.addObserver((PlaylistObserver) iteratorByArtist);
        System.out.println("Songs in the playlist are: ");
        System.out.println("-----------------------------------------");
        print(iterator);

        System.out.println();

        System.out.println("songs by shruti are: ");
        System.out.println("-----------------------------------------");
        print(iteratorByArtist);

        p1.addSong(new Song("Dheevara", "keeravani"));

        System.out.println("songs by shruti are: ");
        System.out.println("-----------------------------------------");
        print(iteratorByArtist);

        p1.deleteSong(2);

        System.out.println("songs by shruti are: ");
        System.out.println("-----------------------------------------");
        print(iteratorByArtist);

        p1.addSong(new Song("charuseela", "shruti"));
        p1.addSong(new Song("dhimmatirige", "shruti"));

        System.out.println("songs by shruti are: ");
        System.out.println("-----------------------------------------");
        print(iteratorByArtist);

    }


}
