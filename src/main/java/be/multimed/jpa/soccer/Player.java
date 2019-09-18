package be.multimed.jpa.soccer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(PlayerPK.class)
public class Player {
    private String club;
    private int number;
    private String name;

    public Player() {
    }

    public Player(String club, int number, String name) {
        this.club = club;
        this.number = number;
        this.name = name;
    }

    @Id
    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getNumber() == player.getNumber() &&
                Objects.equals(getClub(), player.getClub()) &&
                Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClub(), getNumber(), getName());
    }

    @Override
    public String toString() {
        return "Player{" +
                "club='" + club + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
