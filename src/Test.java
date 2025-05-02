//public class Test {
//    public static void main(String[] args) {
//        int[] i1 = {4, 4, 3, 2, 2};
//        int[] i2 = {4, 2, 2, 1, 1};
//        int[] i3 = {4, 4, 2, 2, 1};
//
////        System.out.println("point1 = " + getPoint(i1, 0));
////        System.out.println("point2 = " + getPoint(i1, getPoint(i1, 0) + 1));
////        System.out.println("point3 = " + getPoint(i1, getPoint(i1, getPoint(i1, 0) + 1) + 1));
////        System.out.println();
////
////        System.out.println("point1 = " + getPoint(i2, 0));
////        System.out.println("point2 = " + getPoint(i2, getPoint(i2, 0) + 1));
////        System.out.println("point3 = " + getPoint(i2, getPoint(i2, getPoint(i2, 0) + 1) + 1));
////        System.out.println();
//
//        int[] pointers = new int[3];
//
//        getPoint(i1, pointers, 0, 0);
//        for (int i = 0; i < pointers.length; i++) {
//            System.out.println(pointers[i]);
//        }
//        System.out.println();
//
//        getPoint(i2, pointers, 0, 0);
//        for (int i = 0; i < pointers.length; i++) {
//            System.out.println(pointers[i]);
//        }
//        System.out.println();
//
//        getPoint(i3, pointers, 0, 0);
//        for (int i = 0; i < pointers.length; i++) {
//            System.out.println(pointers[i]);
//        }
//
////        System.out.println("point1 = " + getPoint(i3, 0));
////        System.out.println("point2 = " + getPoint(i3, getPoint(i3, 0) + 1));
////        System.out.println("point3 = " + getPoint(i3, getPoint(i3, getPoint(i3, 0) + 1) + 1));
//        System.out.println();
//
//
//    }
//
//    public static void getPoint(int[] cards, int[] pointers, int start, int count) {
//        if (count == 3) return ;
//        for (int i = start; i < 4; i++) {
//            if (cards[i] != cards[i + 1]) {
//                pointers[count] = i;
//                getPoint(cards, pointers, i + 1, count + 1);
//                return ;
//            }
//        }
//        pointers[count] = 4;
//        getPoint(cards, pointers, 4, count + 1);
//    }
//}
import java.util.Iterator;

public class PlaylistTest {
    public static void main(String[] args) {
        Playlist playlist = new Playlist(3);
        playlist.addSong(new Song("Imagine - John Lennon"));
        playlist.addSong(new Song("Let It Be - The Beatles"));
        playlist.addSong(new Song("Bohemian Rhapsody - Queen"));

        System.out.println("🎵 순서대로 노래 목록 출력:");
        for (Song song : playlist) {
            System.out.println(song.getTitle());
        }
    }
}

class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Playlist implements Iterable<Song> {
    private Song[] songs;
    private int size = 0;

    public Playlist(int capacity) {
        songs = new Song[capacity];
    }

    public void addSong(Song song) {
        songs[size++] = song;
    }

    public Song getSongAt(int index) {
        return songs[index];
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Song> iterator() {
        return new SongIterator(this);
    }
}

class SongIterator implements Iterator<Song> {
    private Playlist playlist;
    private int index = 0;

    public SongIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public Song next() {
        return playlist.getSongAt(index++);
    }
}

