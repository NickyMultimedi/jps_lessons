package be.multimed.jpa.cats;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@IdClass(CatPK.class)
public class Cat implements Serializable {
    @Id
    private String ras;
    @Id
    private String naam;
    private String koosnaam;
    private String eigenaar;
    private String locatie;
    @Id
    private LocalDate geboorteDatum;

    public Cat() {
    }

    public Cat(String ras, String naam, LocalDate geboorteDatum) {
        this.ras = ras;
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
    }

    public Cat(String ras, String naam, String koosnaam, String eigenaar, String locatie, LocalDate geboorteDatum) {
        this(ras, naam, geboorteDatum);
        this.koosnaam = koosnaam;
        this.eigenaar = eigenaar;
        this.locatie = locatie;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKoosnaam() {
        return koosnaam;
    }

    public void setKoosnaam(String koosnaam) {
        this.koosnaam = koosnaam;
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(String eigenaar) {
        this.eigenaar = eigenaar;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getRas(), cat.getRas()) &&
                Objects.equals(getNaam(), cat.getNaam()) &&
                Objects.equals(getKoosnaam(), cat.getKoosnaam()) &&
                Objects.equals(getEigenaar(), cat.getEigenaar()) &&
                Objects.equals(getLocatie(), cat.getLocatie()) &&
                Objects.equals(getGeboorteDatum(), cat.getGeboorteDatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRas(), getNaam(), getKoosnaam(), getEigenaar(), getLocatie(), getGeboorteDatum());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "ras='" + ras + '\'' +
                ", naam='" + naam + '\'' +
                ", koosnaam='" + koosnaam + '\'' +
                ", eigenaar='" + eigenaar + '\'' +
                ", locatie='" + locatie + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                '}';
    }
}
