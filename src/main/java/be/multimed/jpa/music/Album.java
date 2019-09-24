package be.multimed.jpa.music;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Album")
public class Album implements Serializable {
    @Column(name = "AlbumId") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "Author", nullable = false) String author;
    @Column(name = "Title", nullable = false) String title;
    @ElementCollection(fetch = FetchType.EAGER) @CollectionTable(name = "Tracks") List<String> tracks = new ArrayList<>();

    public Album() {
    }

    public Album(String author, String title, List<String> tracks) {
        this.author = author;
        this.title = title;
        this.tracks = tracks;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return getId() == album.getId() &&
                Objects.equals(getAuthor(), album.getAuthor()) &&
                Objects.equals(getTitle(), album.getTitle()) &&
                Objects.equals(getTracks(), album.getTracks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getTracks());
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
