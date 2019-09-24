package be.multimed.jpa.medical;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class PatientRepoImpl implements PatientRepo {
    @Override
    public void save(Patient patient) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(patient);

            handler.commitTransaction();
        }
    }

    @Override
    public Patient find(long patientId) {
        Patient patient;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            patient = handler.find(Patient.class, patientId);
            patient.getMedicalFile();

            handler.commitTransaction();
        }

        return patient;
    }

    @Override
    public void remove(Patient patient) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            Patient removingPatient = handler.getManager().getReference(Patient.class, patient.getId());
            removingPatient.removeMedicalFile();
            handler.getManager().remove(removingPatient);

            handler.commitTransaction();
        }
    }
}
