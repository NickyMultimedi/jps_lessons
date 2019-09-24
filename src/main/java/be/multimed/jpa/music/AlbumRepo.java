package be.multimed.jpa.music;

public interface AlbumRepo {
    void save(Album album);
    Album find(long id);
}
