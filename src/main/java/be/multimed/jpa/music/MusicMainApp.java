package be.multimed.jpa.music;

import java.util.ArrayList;
import java.util.List;

public class MusicMainApp {
    public static void main(String[] args) {
        AlbumRepo repo = new AlbumRepoImpl();

        List<String> tracks = new ArrayList<>();
        tracks.add("Intro");
        tracks.add("a New Hope");
        tracks.add("a Millenium Falcon");
        tracks.add("a Game of Fathers");
        tracks.add("Losing Luke");
        tracks.add("Rise of the Ewoks");

        Album album = new Album(
                "Nick Williams",
                "Star Dreams",
                tracks
        );

        System.out.println(album);
        repo.save(album);
        Album album2 = repo.find(1);
        System.out.println(album2);
    }
}
