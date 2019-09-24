package be.multimed.jpa.medical;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MedicalFile implements Serializable {
    @Id @Column(name = "MedicalFileId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "PatientHeight") double height;
    @Column(name = "PatientWeight") double weight;
    @OneToOne(mappedBy = "medicalFile") Patient patient;

    public MedicalFile() {
    }

    public MedicalFile(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public MedicalFile(double height, double weight, Patient patient) {
        this.height = height;
        this.weight = weight;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalFile that = (MedicalFile) o;
        return getId() == that.getId() &&
                Double.compare(that.getHeight(), getHeight()) == 0 &&
                Double.compare(that.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHeight(), getWeight());
    }

    @Override
    public String toString() {
        return "MedicalFile{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
