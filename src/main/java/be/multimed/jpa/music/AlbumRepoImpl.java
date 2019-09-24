package be.multimed.jpa.music;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class AlbumRepoImpl implements AlbumRepo {
    @Override
    public void save(Album album) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            if (album.getId() != 0) {
                handler.merge(album);
            } else {
                handler.persist(album);
            }

            handler.commitTransaction();
        }
    }

    @Override
    public Album find(long id) {
        Album album;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            album = handler.find(Album.class, id);
        }

        return album;
    }
}
