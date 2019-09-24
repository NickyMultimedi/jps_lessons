package be.multimed.jpa.medical;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Patient implements Serializable {
    @Id @Column(name = "PatientId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "Name") String name;
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true) @JoinColumn(name = "MedicalFileId") MedicalFile medicalFile;

    public Patient() {
    }

    public Patient(String name, MedicalFile medicalFile) {
        this.name = name;
        this.medicalFile = medicalFile;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    public void addMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
        medicalFile.setPatient(this);
    }

    public void removeMedicalFile() {
        if (medicalFile != null) {
            medicalFile.setPatient(null);
            medicalFile = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() &&
                Objects.equals(getName(), patient.getName()) &&
                Objects.equals(getMedicalFile(), patient.getMedicalFile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMedicalFile());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", medicalFile=" + medicalFile +
                '}';
    }
}
