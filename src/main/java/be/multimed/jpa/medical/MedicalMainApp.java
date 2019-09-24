package be.multimed.jpa.medical;

public class MedicalMainApp {
    public static void main(String[] args) {
        PatientRepo repo = new PatientRepoImpl();

        MedicalFile file = new MedicalFile(1.72, 66);
        Patient patient = new Patient("Nick Bauters", file);

        repo.save(patient);

        Patient pat2 = repo.find(1L);
        repo.remove(pat2);
        System.out.println(pat2);
    }
}
