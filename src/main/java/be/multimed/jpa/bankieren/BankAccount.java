package be.multimed.jpa.bankieren;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class BankAccount implements Serializable {
    @Id
    String iban;
    String bic;
    String naam;
    String kaartNummer;
    BigDecimal saldo;
    @Version
    int version;

    public BankAccount() {
    }

    public BankAccount(String iban, String bic, String naam, String kaartNummer, BigDecimal saldo) {
        this.iban = iban;
        this.bic = bic;
        this.naam = naam;
        this.kaartNummer = kaartNummer;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(String kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(getIban(), that.getIban()) &&
                Objects.equals(getBic(), that.getBic()) &&
                Objects.equals(getNaam(), that.getNaam()) &&
                Objects.equals(getKaartNummer(), that.getKaartNummer()) &&
                Objects.equals(getSaldo(), that.getSaldo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIban(), getBic(), getNaam(), getKaartNummer(), getSaldo());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", naam='" + naam + '\'' +
                ", kaartNummer='" + kaartNummer + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
