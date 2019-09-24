package be.multimed.jpa.medical;

public interface PatientRepo {
    void save(Patient patient);
    Patient find(long patientId);
    void remove(Patient patient);
}
