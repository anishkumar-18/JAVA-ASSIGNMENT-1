import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    void addSong(String song) {
        if (song != null && count < songs.length) {
            songs[count++] = song;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Count: " + p.getSongCount());
    }
}
