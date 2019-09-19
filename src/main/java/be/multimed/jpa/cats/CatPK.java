package be.multimed.jpa.cats;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CatPK implements Serializable {
    private String naam;
    private String ras;
    private LocalDate geboorteDatum;

    public CatPK() {
    }

    public CatPK(String naam, String ras, LocalDate geboorteDatum) {
        this.naam = naam;
        this.ras = ras;
        this.geboorteDatum = geboorteDatum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
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
        CatPK catPK = (CatPK) o;
        return getNaam().equals(catPK.getNaam()) &&
                getRas().equals(catPK.getRas()) &&
                getGeboorteDatum().equals(catPK.getGeboorteDatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNaam(), getRas(), getGeboorteDatum());
    }

    @Override
    public String toString() {
        return "CatPK{" +
                "naam='" + naam + '\'' +
                ", ras='" + ras + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                '}';
    }
}
